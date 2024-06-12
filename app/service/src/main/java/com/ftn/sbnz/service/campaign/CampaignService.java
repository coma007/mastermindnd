package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.dtos.CampaignDTO;
import com.ftn.sbnz.model.events.ThemeQuery;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.CampaignTheme;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.enums.Theme;
import com.ftn.sbnz.service.user.IUserRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private ICampaignRepository repository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private KieSession kieSession;
    @Autowired
    private KieContainer kieContainer;
    @Autowired
    private ICampaignThemeRepository campaignThemeRepository;

    public Campaign findById(Long id) {
        Optional<Campaign> campaign = repository.findById(id);
        return campaign.orElse(null);
    }

    public List<Campaign> findAll() {
        List<Campaign> campaigns = repository.findAll();
        return campaigns;
    }

    public CampaignDTO create(CampaignDTO newCampaign) {
        Campaign c = newCampaign.toModel();
        c = repository.save(c);
        KieSession session = kieSession;
        List<Campaign> searchResults = new ArrayList<>();
        session.setGlobal("searchResults", searchResults);

        session.insert(c);
        for (User u : userRepository.findAll()) {
            session.insert(u);
            session.insert(u.getHistory());
            session.insert(u.getPreference());
            session.insert(u.getWishlist());
        }
        session.fireAllRules();
        return new CampaignDTO(c);
    }

    public List<Campaign> findByTheme(Theme t) {
        KieSession kieSessionTheme = kieContainer.newKieSession("themeFinder");
        List<Campaign> campaigns = new ArrayList<>();
        List<String> results = new ArrayList<>();
        ThemeQuery q = new ThemeQuery();
        q.setTimestamp(new Date());
        q.setBaseTheme(t);
        kieSessionTheme.insert(q);
        kieSessionTheme.setGlobal("results", results);
        for (CampaignTheme ct : campaignThemeRepository.findAll())
        {
            kieSessionTheme.insert(ct);
        }
        kieSessionTheme.fireAllRules();
        for (String name : results) {
            repository.findByName(name).ifPresent(campaigns::add);
        }
        return campaigns;
    }

    public Theme findBaseTheme(Campaign c) {
        CampaignTheme ct = c.getCampaignTheme();
        while (true) {
            try {
                Theme theme = Theme.valueOf(ct.getParentTheme());
                return theme;
            } catch (IllegalArgumentException ignored) {
                ct = campaignThemeRepository.findByThemeName(ct.getParentTheme());
            }
        }
    }
}

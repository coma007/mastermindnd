package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.events.AddCampaignEvent;
import com.ftn.sbnz.model.events.SearchEvent;
import com.ftn.sbnz.model.events.enums.AddCampaignType;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.CampaignMatch;
import com.ftn.sbnz.model.models.SearchData;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.enums.*;
import com.ftn.sbnz.service.campaign.CampaignService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActivityService {

    @Autowired
    private IUserRepository repository;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private KieSession kieSession;

    @Transactional
    public void saveCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setTimestamp(new Date());
        e.setType(AddCampaignType.SAVE);

        List<Campaign> campaigns = campaignService.findAll();

        List<Campaign> searchResults = new ArrayList<>();
        kieSession.setGlobal("searchResults", searchResults);

        kieSession.insert(user);
        kieSession.insert(user.getHistory());
        kieSession.insert(user.getPreference());
        kieSession.insert(user.getWishlist());
        kieSession.insert(e);
        for (Campaign c : campaigns) {
            kieSession.insert(c);
        }
        kieSession.fireAllRules();
        repository.save(user);
    }

    @Transactional
    public void likeCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;


        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setTimestamp(new Date());
        e.setType(AddCampaignType.LIKE);

        List<Campaign> campaigns = campaignService.findAll();
        List<Campaign> searchResults = new ArrayList<>();
        kieSession.setGlobal("searchResults", searchResults);

        kieSession.insert(user);
        kieSession.insert(user.getHistory());
        kieSession.insert(user.getPreference());
        kieSession.insert(user.getWishlist());
        kieSession.insert(e);
        for (Campaign c : campaigns) {
            kieSession.insert(c);
        }
        kieSession.fireAllRules();

        repository.save(user);
    }

    @Transactional
    public void playCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setTimestamp(new Date());
        e.setType(AddCampaignType.PLAY);

        List<Campaign> campaigns = campaignService.findAll();

        KieSession session = kieSession;
        List<Campaign> searchResults = new ArrayList<>();
        session.setGlobal("searchResults", searchResults);

        session.insert(user);
        session.insert(user.getHistory());
        session.insert(user.getPreference());
        session.insert(user.getWishlist());
        session.insert(e);
        for (Campaign c : campaigns) {
            session.insert(c);
        }
        session.fireAllRules();

        repository.save(user);
    }

    public List<Campaign> getCampaigns(String type, Long userId) {
        User user = repository.findById(userId).orElse(null);
        switch (type) {
            case "recommended":
                return user.getRecommendedCampaigns();
            case "preference":
                return user.getPreference().getCampaigns();
            case "history":
                return user.getHistory().getCampaigns();
            case "wishlist":
                return user.getWishlist().getCampaigns();
            default:
                return new ArrayList<>();
        }
    }

    public List<Campaign> searchCampaigns(SearchData data, Long userId) {
        User user = repository.findById(userId).orElse(null);
        if (user == null) return List.of();

        KieSession session = kieSession;
        session.insert(data);

        List<Campaign> searchResults = new ArrayList<>();
        session.setGlobal("searchResults", searchResults);

        SearchEvent searchEvent = new SearchEvent(data);
        session.insert(searchEvent);

        List<Campaign> campaigns = campaignService.findAll();
        for (Campaign c : campaigns) {
            session.insert(c);
        }

        session.fireAllRules();

        return searchResults;
    }
}

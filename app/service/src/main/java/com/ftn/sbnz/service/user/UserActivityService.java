package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.events.AddCampaignEvent;
import com.ftn.sbnz.model.events.enums.AddCampaignType;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.campaign.CampaignService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private CampaignService campaignService;

    public void saveCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.SAVE);

        List<Campaign> campaigns = campaignService.findAll();

        ksession.insert(user);
        ksession.insert(user.getCurrentPreferences());
        ksession.insert(user.getHistory());
        ksession.insert(user.getPreference());
        ksession.insert(user.getWishlist());
        ksession.insert(e);
        for (Campaign c : campaigns) {
            ksession.insert(c);
        }
        ksession.fireAllRules();

        repository.save(user);
    }

    public void likeCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.LIKE);

        List<Campaign> campaigns = campaignService.findAll();

        ksession.insert(user);
        ksession.insert(user.getCurrentPreferences());
        ksession.insert(user.getHistory());
        ksession.insert(user.getPreference());
        ksession.insert(user.getWishlist());
        ksession.insert(e);
        for (Campaign c : campaigns) {
            ksession.insert(c);
        }
        ksession.fireAllRules();

        repository.save(user);
    }

    public void playCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.PLAY);

        List<Campaign> campaigns = campaignService.findAll();

        ksession.insert(user);
        ksession.insert(user.getCurrentPreferences());
        ksession.insert(user.getHistory());
        ksession.insert(user.getPreference());
        ksession.insert(user.getWishlist());
        ksession.insert(e);
        for (Campaign c : campaigns) {
            ksession.insert(c);
        }
        ksession.fireAllRules();

        repository.save(user);
    }
}

package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.events.AddCampaignEvent;
import com.ftn.sbnz.model.events.enums.AddCampaignType;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.campaign.CampaignService;
import com.ftn.sbnz.service.kie_session.KSessionService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityService {

    @Autowired
    private IUserRepository repository;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private KSessionService userActivityServiceSession;


    public void saveCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.SAVE);

        List<Campaign> campaigns = campaignService.findAll();

        userActivityServiceSession.getUserActivitySession().insert(user);
        userActivityServiceSession.getUserActivitySession().insert(user.getCurrentPreferences());
        userActivityServiceSession.getUserActivitySession().insert(user.getHistory());
        userActivityServiceSession.getUserActivitySession().insert(user.getPreference());
        userActivityServiceSession.getUserActivitySession().insert(user.getWishlist());
        userActivityServiceSession.getUserActivitySession().insert(e);
        for (Campaign c : campaigns) {
            userActivityServiceSession.getUserActivitySession().insert(c);
        }
        userActivityServiceSession.getUserActivitySession().fireAllRules();
        repository.save(user);
    }

    public void likeCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;


        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.LIKE);

        List<Campaign> campaigns = campaignService.findAll();

        userActivityServiceSession.getUserActivitySession().insert(user);
        userActivityServiceSession.getUserActivitySession().insert(user.getCurrentPreferences());
        userActivityServiceSession.getUserActivitySession().insert(user.getHistory());
        userActivityServiceSession.getUserActivitySession().insert(user.getPreference());
        userActivityServiceSession.getUserActivitySession().insert(user.getWishlist());
        userActivityServiceSession.getUserActivitySession().insert(e);
        for (Campaign c : campaigns) {
            userActivityServiceSession.getUserActivitySession().insert(c);
        }
        userActivityServiceSession.getUserActivitySession().fireAllRules();

        repository.save(user);
    }

    public void playCampaign(Long campaignId, Long userId) {
        Campaign campaign = campaignService.findById(campaignId);
        if (campaign == null) return;
        User user = repository.findById(userId).orElse(null);
        if (user == null) return;

        AddCampaignEvent e = new AddCampaignEvent();
        e.setCampaign(campaign);
        e.setUser(user);
        e.setType(AddCampaignType.PLAY);

        List<Campaign> campaigns = campaignService.findAll();

        KieSession session = userActivityServiceSession.getUserActivitySession();
        session.insert(user);
        session.insert(user.getCurrentPreferences());
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
}

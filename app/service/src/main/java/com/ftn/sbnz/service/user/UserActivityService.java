package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.events.SaveCampaignEvent;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.campaign.CampaignService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.kie.api.runtime.KieSession;

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

        user.getSavedCampaigns().add(campaign);

        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");

        SaveCampaignEvent s = new SaveCampaignEvent();
        s.setCampaign(campaign);
        s.setUser(user);
        ksession.insert(s);
        ksession.fireAllRules();

        repository.save(user);
    }
}

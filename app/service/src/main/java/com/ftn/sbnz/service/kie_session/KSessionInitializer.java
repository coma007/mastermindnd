package com.ftn.sbnz.service.kie_session;

import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.campaign.ICampaignRepository;
import com.ftn.sbnz.service.user.IUserRepository;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Component;

@Component
public class KSessionInitializer implements ApplicationRunner {

    @Autowired
    private KieSession kieSession;
    @Autowired
    private final IUserRepository userRepository;
    @Autowired
    private final ICampaignRepository campaignRepository;
    @Autowired
    private ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

    public KSessionInitializer(KieSession kieSession, ICampaignRepository campaignRepository, IUserRepository userRepository) {
        this.kieSession = kieSession;
        this.campaignRepository = campaignRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("Initializing KieSession");


        // Get all campaigns
//        for (Campaign c : campaignRepository.findAll()) {
//            kieSession.insert(c);
//        }

        // Get all users
//        for (User u : userRepository.findAll()) {
//            kieSession.insert(u);
//            kieSession.insert(u.getHistory());
//            kieSession.insert(u.getPreference());
//            kieSession.insert(u.getWishlist());
//        }

    }


}

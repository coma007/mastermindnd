package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.dtos.CampaignDTO;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.service.kie_session.KSessionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private ICampaignRepository repository;
    @Autowired
    private KSessionService userActivityServiceSession;


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
        KieSession session = userActivityServiceSession.getUserActivitySession();
        session.insert(c);
        session.fireAllRules();
        return new CampaignDTO(c);
    }
}

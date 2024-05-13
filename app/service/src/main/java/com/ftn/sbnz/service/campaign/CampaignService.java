package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.dtos.CampaignDTO;
import com.ftn.sbnz.model.models.Campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private ICampaignRepository repository;

    public Campaign findById(Long id) {
        Optional<Campaign> campaign = repository.findById(id);
        return campaign.orElse(null);
    }

    public CampaignDTO create(CampaignDTO newCampaign) {
        Campaign c = newCampaign.toModel();
        c = repository.save(c);
        return new CampaignDTO(c);
    }
}

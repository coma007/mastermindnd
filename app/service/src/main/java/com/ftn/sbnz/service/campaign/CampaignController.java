package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.dtos.CampaignDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PostMapping("/create")
    public ResponseEntity<CampaignDTO> createCampaign(@RequestBody CampaignDTO newCampaign) {
        CampaignDTO createdCampaign = service.create(newCampaign);
        return new ResponseEntity(createdCampaign, HttpStatus.OK);
    }
}

package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.dtos.CampaignDTO;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.enums.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/campaign")
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PostMapping("/create")
    public ResponseEntity<CampaignDTO> createCampaign(@RequestBody CampaignDTO newCampaign) {
        Theme campaigns = service.findBaseTheme(service.findById(1L));
        CampaignDTO createdCampaign = service.create(newCampaign);
        return new ResponseEntity(createdCampaign, HttpStatus.OK);
    }

    @GetMapping("/themeSearch")
    public ResponseEntity<List<CampaignDTO>> searchByTheme(@RequestParam String theme) {
        List<Campaign> campaigns = service.findByTheme(Theme.valueOf(theme.toUpperCase()));
        List<CampaignDTO> dtos = new ArrayList<>();
        for (Campaign c : campaigns) {
            dtos.add(new CampaignDTO(c));
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}

package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.models.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICampaignRepository extends JpaRepository<Campaign, Long> {
}

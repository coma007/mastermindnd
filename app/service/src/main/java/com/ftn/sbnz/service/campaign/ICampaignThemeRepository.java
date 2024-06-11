package com.ftn.sbnz.service.campaign;

import com.ftn.sbnz.model.models.CampaignTheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICampaignThemeRepository extends JpaRepository<CampaignTheme, Long> {
    public CampaignTheme findByThemeName(String themeName);
}

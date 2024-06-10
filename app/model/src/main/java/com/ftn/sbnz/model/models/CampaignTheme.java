package com.ftn.sbnz.model.models;

import org.kie.api.definition.type.Position;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CampaignTheme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Position(0)
    private String themeName;

    @Position(1)
    private String parentTheme;

    public CampaignTheme(String themeName, String parentTheme) {
        this.themeName = themeName;
        this.parentTheme = parentTheme;
    }

    public CampaignTheme() {

    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getParentTheme() {
        return parentTheme;
    }

    public void setParentTheme(String parentTheme) {
        this.parentTheme = parentTheme;
    }
}


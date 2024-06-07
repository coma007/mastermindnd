package com.ftn.sbnz.model.dtos;

import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.enums.GameplayStyle;
import com.ftn.sbnz.model.models.enums.Level;
import com.ftn.sbnz.model.models.enums.Theme;

public class CampaignDTO {
    private String name;
    private Theme theme;
    private GameplayStyle gameplayStyle;
    private Long estimatedDuration;
    private Integer partySize;
    private Level level;
    private String summary;

    public Campaign toModel() {
        Campaign c = new Campaign();
        c.setName(this.name);
        c.setEstimatedDuration(this.estimatedDuration);
        c.setLevel(this.level);
        c.setSummary(this.summary);
        c.setTheme(this.theme);
        c.setGameplayStyle(this.gameplayStyle);
        c.setPartySize(this.partySize);
        return c;
    }

    public CampaignDTO() {
    }

    public CampaignDTO(String name, Theme theme, GameplayStyle gameplayStyle, Long estimatedDuration,
                       Integer partySize, Level level, String summary) {
        this.name = name;
        this.theme = theme;
        this.gameplayStyle = gameplayStyle;
        this.estimatedDuration = estimatedDuration;
        this.partySize = partySize;
        this.level = level;
        this.summary = summary;
    }

    public CampaignDTO(Campaign c) {
        this.name = c.getName();
        this.theme = c.getTheme();
        this.gameplayStyle = c.getGameplayStyle();
        this.estimatedDuration = c.getEstimatedDuration();
        this.partySize = c.getPartySize();
        this.level = c.getLevel();
        this.summary = c.getSummary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public GameplayStyle getGameplayStyle() {
        return gameplayStyle;
    }

    public void setGameplayStyle(GameplayStyle gameplayStyle) {
        this.gameplayStyle = gameplayStyle;
    }

    public Long getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Long estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Integer getPartySize() {
        return partySize;
    }

    public void setPartySize(Integer partySize) {
        this.partySize = partySize;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

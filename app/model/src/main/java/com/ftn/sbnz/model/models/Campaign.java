package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.*;

import javax.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Theme theme;
    private GameplayStyle gameplayStyle;
    private Long estimatedDuration;
    private Integer partySize;
    private Level level;
    @Column(length = 1024)
    private String summary;

    public Campaign(String name, Theme theme, GameplayStyle gameplayStyle, Long estimatedDuration, Integer partySize, Level level, String summary) {
        this.name = name;
        this.theme = theme;
        this.gameplayStyle = gameplayStyle;
        this.estimatedDuration = estimatedDuration;
        this.partySize = partySize;
        this.level = level;
        this.summary = summary;
    }

    public Campaign() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

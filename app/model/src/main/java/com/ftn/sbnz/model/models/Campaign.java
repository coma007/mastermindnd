package com.ftn.sbnz.model.models;

public class Campaign {
    private String name;
    private Theme theme;
    private GameplayStyle gameplayStyle;
    private Long estimatedDuration;
    private Integer partySize;
    private Level level;
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

}

package com.ftn.sbnz.model.models;

import java.util.List;

public class SearchData {

        private List<String> theme;
        private List<String> level;
        private List<String> gameplayStyle;
        private List<String> characterClass;
        private List<String> characterRace;
        private List<String> duration;
        private List<String> partySize;

    public List<String> getTheme() {
        return theme;
    }

    public void setTheme(List<String> theme) {
        this.theme = theme;
    }

    public List<String> getLevel() {
        return level;
    }

    public void setLevel(List<String> level) {
        this.level = level;
    }

    public List<String> getGameplayStyle() {
        return gameplayStyle;
    }

    public void setGameplayStyle(List<String> gameplayStyle) {
        this.gameplayStyle = gameplayStyle;
    }

    public List<String> getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(List<String> characterClass) {
        this.characterClass = characterClass;
    }

    public List<String> getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(List<String> characterRace) {
        this.characterRace = characterRace;
    }

    public List<String> getDuration() {
        return duration;
    }

    public void setDuration(List<String> duration) {
        this.duration = duration;
    }

    public List<String> getPartySize() {
        return partySize;
    }

    public void setPartySize(List<String> partySize) {
        this.partySize = partySize;
    }
}

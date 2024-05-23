package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.GameplayStyle;
import com.ftn.sbnz.model.models.enums.Level;
import com.ftn.sbnz.model.models.enums.Theme;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Campaign> campaigns;
    @ElementCollection
    private List<Theme> themes;
    @ElementCollection
    private List<Level> levels;
    @ElementCollection
    private List<GameplayStyle> styles;
    private Level bestLevel;
    private Theme bestTheme;
    private GameplayStyle bestStyle;
    
    public void addLevel(Level l) {
        this.levels.add(l);
        if (this.bestLevel == null) {
            this.bestLevel = l;
            return;
        }
        this.bestLevel = findMostCommon(this.levels);
    }
    public void addTheme(Theme t) {
        this.themes.add(t);
        if (this.bestTheme == null) {
            this.bestTheme = t;
            return;
        }
        this.bestTheme = findMostCommon(this.themes);
    }
    public void addStyle(GameplayStyle s) {
        this.styles.add(s);
        if (this.bestStyle == null) {
            this.bestStyle = s;
            return;
        }
        this.bestStyle = findMostCommon(this.styles);
    }

    public void addCampaign(Campaign c) {
        if (this.campaigns.contains(c)) return;
        this.campaigns.add(c);
        this.addLevel(c.getLevel());
        this.addStyle(c.getGameplayStyle());
        this.addTheme(c.getTheme());
    }
    public UserActivity(Long id, List<Campaign> campaigns, List<Theme> themes, List<Level> levels, List<GameplayStyle> styles) {
        this.id = id;
        this.campaigns = campaigns;
        this.themes = themes;
        this.levels = levels;
        this.styles = styles;
    }

    public UserActivity() {
        this.campaigns = new ArrayList<>();
        this.levels = new ArrayList<>();
        this.themes = new ArrayList<>();
        this.styles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<GameplayStyle> getStyles() {
        return styles;
    }

    public void setStyles(List<GameplayStyle> styles) {
        this.styles = styles;
    }

    public Level getBestLevel() {
        return bestLevel;
    }

    public void setBestLevel(Level bestLevel) {
        this.bestLevel = bestLevel;
    }

    public Theme getBestTheme() {
        return bestTheme;
    }

    public void setBestTheme(Theme bestTheme) {
        this.bestTheme = bestTheme;
    }

    public GameplayStyle getBestStyle() {
        return bestStyle;
    }

    public void setBestStyle(GameplayStyle bestStyle) {
        this.bestStyle = bestStyle;
    }

    private <T> T findMostCommon(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty");
        }

        // Map to keep track of the frequency of each element
        Map<T, Integer> frequencyMap = new HashMap<>();

        // Populate the frequency map
        for (T element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        // Find the most common element
        T mostCommon = null;
        int maxCount = -1;
        for (Map.Entry<T, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }

}

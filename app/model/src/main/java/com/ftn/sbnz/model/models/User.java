package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.GameplayStyle;
import com.ftn.sbnz.model.models.enums.Level;
import com.ftn.sbnz.model.models.enums.Theme;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @ManyToMany
    private List<Campaign> savedCampaigns;
    @ElementCollection
    private List<Theme> themeWishlist;
    @ElementCollection
    private List<Level> levelWishlist;
    @ElementCollection
    private List<GameplayStyle> styleWishlist;
    @ManyToMany
    private List<Campaign> likedCampaigns;
    @ElementCollection
    private List<Theme> themePreference;
    @ElementCollection
    private List<Level> levelPreference;
    @ElementCollection
    private List<GameplayStyle> stylePreference;
    @ManyToMany
    private List<Campaign> historyCampaigns;
    @ElementCollection
    private List<Theme> themeHistory;
    @ElementCollection
    private List<Level> levelHistory;
    @ElementCollection
    private List<GameplayStyle> styleHistory;
    @ManyToMany
    private List<Rating> ratings;
    @ManyToMany
    private List<Campaign> recommendedCampaigns;
    private boolean recommendNewFromHistory;
    private boolean recommendNewFromPreference;
    private boolean recommendNewFromWishlist;

    public void recommendNew(Campaign c) {
        this.recommendedCampaigns.add(c);
    }

    public void addLevelToHistory(Level l) {
        this.levelHistory.add(l);
    }

    public void addLevelToWishlist(Level l) {
        this.levelWishlist.add(l);
    }

    public void addLevelToPreference(Level l) {
        this.levelPreference.add(l);
    }

    public void addThemeToHistory(Theme t) {
        this.themeHistory.add(t);
    }

    public void addThemeToWishlist(Theme t) {
        this.themeWishlist.add(t);
    }

    public void addThemeToPreference(Theme t) {
        this.themePreference.add(t);
    }

    public void addStyleToHistory(GameplayStyle s) {
        this.styleHistory.add(s);
    }

    public void addStyleToWishlist(GameplayStyle s) {
        this.styleWishlist.add(s);
    }

    public void addStyleToPreference(GameplayStyle s) {
        this.stylePreference.add(s);
    }

    public User(String name) {
        this.name = name;
        this.recommendedCampaigns = new ArrayList<>();
        this.historyCampaigns = new ArrayList<>();
        this.likedCampaigns = new ArrayList<>();
        this.savedCampaigns = new ArrayList<>();
        this.themeHistory = new ArrayList<>();
        this.themePreference = new ArrayList<>();
        this.themeWishlist = new ArrayList<>();
        this.levelHistory = new ArrayList<>();
        this.levelPreference = new ArrayList<>();
        this.levelWishlist = new ArrayList<>();
        this.styleHistory = new ArrayList<>();
        this.stylePreference = new ArrayList<>();
        this.styleWishlist = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.recommendNewFromHistory = false;
        this.recommendNewFromWishlist = false;
        this.recommendNewFromPreference = false;
    }

    public User() {
    }

    public List<Campaign> getSavedCampaigns() {
        return savedCampaigns;
    }

    public void setSavedCampaigns(List<Campaign> savedCampaigns) {
        this.savedCampaigns = savedCampaigns;
    }

    public List<Theme> getThemeWishlist() {
        return themeWishlist;
    }

    public void setThemeWishlist(List<Theme> themeWishlist) {
        this.themeWishlist = themeWishlist;
    }

    public List<Level> getLevelWishlist() {
        return levelWishlist;
    }

    public void setLevelWishlist(List<Level> levelWishlist) {
        this.levelWishlist = levelWishlist;
    }

    public List<GameplayStyle> getStyleWishlist() {
        return styleWishlist;
    }

    public void setStyleWishlist(List<GameplayStyle> styleWishlist) {
        this.styleWishlist = styleWishlist;
    }

    public List<Campaign> getLikedCampaigns() {
        return likedCampaigns;
    }

    public void setLikedCampaigns(List<Campaign> likedCampaigns) {
        this.likedCampaigns = likedCampaigns;
    }

    public List<Theme> getThemePreference() {
        return themePreference;
    }

    public void setThemePreference(List<Theme> themePreference) {
        this.themePreference = themePreference;
    }

    public List<Level> getLevelPreference() {
        return levelPreference;
    }

    public void setLevelPreference(List<Level> levelPreference) {
        this.levelPreference = levelPreference;
    }

    public List<GameplayStyle> getStylePreference() {
        return stylePreference;
    }

    public void setStylePreference(List<GameplayStyle> stylePreference) {
        this.stylePreference = stylePreference;
    }

    public List<Campaign> getHistoryCampaigns() {
        return historyCampaigns;
    }

    public void setHistoryCampaigns(List<Campaign> historyCampaigns) {
        this.historyCampaigns = historyCampaigns;
    }

    public List<Theme> getThemeHistory() {
        return themeHistory;
    }

    public void setThemeHistory(List<Theme> themeHistory) {
        this.themeHistory = themeHistory;
    }

    public List<Level> getLevelHistory() {
        return levelHistory;
    }

    public void setLevelHistory(List<Level> levelHistory) {
        this.levelHistory = levelHistory;
    }

    public List<GameplayStyle> getStyleHistory() {
        return styleHistory;
    }

    public void setStyleHistory(List<GameplayStyle> styleHistory) {
        this.styleHistory = styleHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Campaign> getRecommendedCampaigns() {
        return recommendedCampaigns;
    }

    public void setRecommendedCampaigns(List<Campaign> recommendedCampaigns) {
        this.recommendedCampaigns = recommendedCampaigns;
    }

    public boolean isRecommendNewFromHistory() {
        return recommendNewFromHistory;
    }

    public void setRecommendNewFromHistory(boolean recommendNew) {
        this.recommendNewFromHistory = recommendNew;
    }

    public boolean isRecommendNewFromPreference() {
        return recommendNewFromPreference;
    }

    public void setRecommendNewFromPreference(boolean recommendNewFromPreference) {
        this.recommendNewFromPreference = recommendNewFromPreference;
    }

    public boolean isRecommendNewFromWishlist() {
        return recommendNewFromWishlist;
    }

    public void setRecommendNewFromWishlist(boolean recommendNewFromWishlist) {
        this.recommendNewFromWishlist = recommendNewFromWishlist;
    }
}
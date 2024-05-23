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

    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity wishlist;
    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity preference;
    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity history;
    @ManyToMany
    private List<Rating> ratings;
    @ManyToMany
    private List<Campaign> recommendedCampaigns;
    @OneToOne(cascade = CascadeType.ALL)
    private UserPreferences currentPreferences;


    public void recommendNew(Campaign c) {
        this.recommendedCampaigns.add(c);
    }
    public User(String name) {
        this.name = name;
        this.recommendedCampaigns = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.currentPreferences = new UserPreferences();
        this.history = new UserActivity();
        this.preference = new UserActivity();
        this.wishlist = new UserActivity();
    }

    public User() {
    }

    public UserPreferences getCurrentPreferences() {
        return currentPreferences;
    }

    public void setCurrentPreferences(UserPreferences preferences) {
        this.currentPreferences = preferences;
    }

    public UserActivity getWishlist() {
        return wishlist;
    }

    public void setWishlist(UserActivity wishlist) {
        this.wishlist = wishlist;
    }

    public UserActivity getPreference() {
        return preference;
    }

    public void setPreference(UserActivity preference) {
        this.preference = preference;
    }

    public UserActivity getHistory() {
        return history;
    }

    public void setHistory(UserActivity history) {
        this.history = history;
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
}
package com.ftn.sbnz.model.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String password;

    @Transient
    private boolean isSearching;

    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity wishlist;
    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity preference;
    @OneToOne(cascade = CascadeType.ALL)
    private UserActivity history;
    @ManyToMany
    private List<Campaign> recommendedCampaigns;


    public void recommendNew(Campaign c) {
        if (this.recommendedCampaigns.contains(c)) return;
        this.recommendedCampaigns.add(c);
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recommendedCampaigns = new ArrayList<>();
        this.history = new UserActivity();
        this.preference = new UserActivity();
        this.wishlist = new UserActivity();
    }

    public User() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Campaign> getRecommendedCampaigns() {
        return recommendedCampaigns;
    }

    public void setRecommendedCampaigns(List<Campaign> recommendedCampaigns) {
        this.recommendedCampaigns = recommendedCampaigns;
    }

    public boolean getIsSearching() {
        return isSearching;
    }

    public void setIsSearching(boolean isSearching) {
        this.isSearching = isSearching;
    }
}
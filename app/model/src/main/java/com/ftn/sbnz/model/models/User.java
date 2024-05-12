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
    private String name;

    @ManyToMany
    private List<Campaign> preferences;

    @ManyToMany
    private List<Campaign> wishlist;

    @ManyToMany
    private List<Campaign> history;

    @ManyToMany
    private List<Rating> ratings;

    public User(String name) {
        this.name = name;
        this.preferences = new ArrayList<>();
        this.wishlist = new ArrayList<>();
        this.history = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public User() {
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

    public List<Campaign> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Campaign> preferences) {
        this.preferences = preferences;
    }

    public List<Campaign> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Campaign> wishlist) {
        this.wishlist = wishlist;
    }

    public List<Campaign> getHistory() {
        return history;
    }

    public void setHistory(List<Campaign> history) {
        this.history = history;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
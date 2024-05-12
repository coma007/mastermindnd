package com.ftn.sbnz.model.models;

import java.util.*;

public class User {
    private Integer id;
    private String name;
    private List<Campaign> preferences;
    private List<Campaign> wishlist;
    private List<Campaign> history;
    private List<Rating> ratings;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.preferences = new ArrayList<>();
        this.wishlist = new ArrayList<>();
        this.history = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }
}
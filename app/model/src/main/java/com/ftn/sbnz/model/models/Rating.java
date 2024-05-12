package com.ftn.sbnz.model.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Campaign campaign;
    private Timestamp timestamp;
    private Integer rating;

    public Rating() {
    }

    public Rating(Campaign campaign, Timestamp timestamp, Integer rating) {
        this.campaign = campaign;
        this.timestamp = timestamp;
        this.rating = rating;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

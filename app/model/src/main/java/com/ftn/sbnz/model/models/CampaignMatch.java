package com.ftn.sbnz.model.models;

public class CampaignMatch {
    private Campaign campaign;
    private int matchCount;

    public CampaignMatch(Campaign campaign, int matchCount) {
        this.campaign = campaign;
        this.matchCount = matchCount;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

package com.ftn.sbnz.model.events;

import com.ftn.sbnz.model.events.enums.AddCampaignType;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.User;
import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class AddCampaignEvent {
    private Long id;
    private Campaign campaign;
    private User user;
    private AddCampaignType type;

    public AddCampaignEvent() {
    }

    public AddCampaignEvent(Long id, Campaign campaign, User user, AddCampaignType type) {
        this.id = id;
        this.campaign = campaign;
        this.user = user;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AddCampaignType getType() {
        return type;
    }

    public void setType(AddCampaignType type) {
        this.type = type;
    }
}

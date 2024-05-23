package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.GameplayStyle;
import com.ftn.sbnz.model.models.enums.Level;
import com.ftn.sbnz.model.models.enums.Theme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Level preferedLevel;
    private GameplayStyle preferedStyle;
    private Theme preferedTheme;

    public UserPreferences() {
    }

    public UserPreferences(Level preferedLevel, GameplayStyle preferedStyle, Theme preferedTheme) {
        this.preferedLevel = preferedLevel;
        this.preferedStyle = preferedStyle;
        this.preferedTheme = preferedTheme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getPreferedLevel() {
        return preferedLevel;
    }

    public void setPreferedLevel(Level preferedLevel) {
        this.preferedLevel = preferedLevel;
    }

    public GameplayStyle getPreferedStyle() {
        return preferedStyle;
    }

    public void setPreferedStyle(GameplayStyle preferedStyle) {
        this.preferedStyle = preferedStyle;
    }

    public Theme getPreferedTheme() {
        return preferedTheme;
    }

    public void setPreferedTheme(Theme preferedTheme) {
        this.preferedTheme = preferedTheme;
    }
}

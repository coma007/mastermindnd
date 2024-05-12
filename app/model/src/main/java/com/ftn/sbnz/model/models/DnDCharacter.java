package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.CharacterClass;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class DnDCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hitPoints;
    private Integer experiencePoints;
    private String name;
    private String race;
    private CharacterClass characterClass;
    private Integer level;
    private Integer xp;
    @OneToOne()
    private Attributes attributes;
    private Integer hits;
    private Integer armorClass;
    private Integer speed;
    @ElementCollection
    private List<String> proficiencies;

    public DnDCharacter() {
    }

    public DnDCharacter(String name, String race, CharacterClass characterClass, Integer level, Integer xp, Attributes attributes, Integer hits, Integer armorClass, Integer speed, List<String> proficiencies) {
        this.name = name;
        this.race = race;
        this.characterClass = characterClass;
        this.level = level;
        this.experiencePoints = xp;
        this.attributes = attributes;
        this.hitPoints = hits;
        this.armorClass = armorClass;
        this.speed = speed;
        this.proficiencies = proficiencies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }
}

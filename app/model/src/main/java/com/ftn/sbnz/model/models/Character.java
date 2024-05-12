package com.ftn.sbnz.model.models;

public class Character {
    private String name;
    private String race;
    private CharacterClass characterClass;
    private Integer level;
    private Integer xp;
    private Attributes attributes;
    private Integer hits;
    private Integer armorClass;
    private Integer speed;
    private List<String> proficiencies;

    public Character(String name, String race, CharacterClass characterClass, Integer level, Integer xp, Attributes attributes, Integer hits, Integer armorClass, Integer speed, List<String> proficiencies) {
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


}

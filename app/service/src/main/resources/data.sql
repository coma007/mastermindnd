CREATE TABLE campaign (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          theme VARCHAR(255),
                          gameplayStyle VARCHAR(255),
                          estimatedDuration BIGINT,
                          partySize INT,
                          level VARCHAR(255),
                          summary TEXT
);

CREATE TABLE attributes (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            strength INT,
                            dexterity INT,
                            constitution INT,
                            intelligence INT,
                            wisdom INT,
                            charisma INT
);

CREATE TABLE dnd_characters (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                hit_points INT,
                                name VARCHAR(255),
                                race VARCHAR(255),
                                character_class VARCHAR(255),
                                level INT,
                                xp INT,
                                hits INT,
                                armor_class INT,
                                speed INT,
                                attributes_id BIGINT,
                                FOREIGN KEY (attributes_id) REFERENCES attributes(id)
);

CREATE TABLE users (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255),
                       recommend_new_from_history BOOLEAN,
                       recommend_new_from_preference BOOLEAN,
                       recommend_new_from_wishlist BOOLEAN
);

CREATE TABLE ratings (
                                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                           campaign_id BIGINT,
                                           timestamp TIMESTAMP,
                                           rating INT,
                                           FOREIGN KEY (campaign_id) REFERENCES campaigns(id)
);


-----------

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Lost Kingdom of Eldoria', 'High Fantasy', 'Story-Driven', 120, 4, 'Intermediate', "Embark on an epic quest to rediscover the ancient kingdom of Eldoria, lost to time and myth. Your party of adventurers will traverse sprawling landscapes, encountering forgotten ruins, mystical forests, and ancient temples. Uncover long-buried secrets, solve puzzles left by the kingdom's founders, and battle mythical creatures to uncover the truth of Eldoria\'s fate. With an estimated duration of 120 hours, this campaign is perfect for a group of four intermediate-level adventurers seeking a rich, immersive storytelling experience.");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('Shadows of the Underworld', 'Dark Fantasy', 'Tactical', 60, 6, 'Advanced', "Descend into the depths of the Underworld in this dark-fantasy campaign. Your party of six advanced adventurers will navigate treacherous terrain, outsmart cunning foes, and uncover the truth behind the shadows that plague the land. With an estimated duration of 60 hours, this campaign offers a thrilling and tactical gameplay experience. Face off against powerful undead lords, navigate through labyrinthine crypts, and make decisions that will shape the fate of the Underworld. Are you ready to brave the Shadows of the Underworld?");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Arcane Chronicles: Rise of the Sorcerer', 'Magic and Mystery', 'Role-Playing', 90, 5, 'Intermediate', 'Embark on a magical journey in "The Arcane Chronicles: Rise of the Sorcerer." As a group of five intermediate-level adventurers, you will delve into a world of ancient spells, mystical artifacts, and arcane mysteries. Uncover the lost history of the legendary sorcerer who once shaped the world with his magic, and discover the true power of the arcane arts. With an estimated duration of 90 hours, this campaign offers a blend of role-playing, puzzle-solving, and magical combat, making it perfect for those seeking a captivating and immersive experience.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('Echoes of the Dragonblood', 'Medieval Fantasy', 'Combat-Heavy', 50, 4, 'Intermediate', 'In "Echoes of the Dragonblood," a combat-heavy campaign for four intermediate-level adventurers, you will journey through a war-torn land where the echoes of ancient battles still linger. As you explore the rugged terrain and besieged cities, you will uncover the remnants of an age-old conflict between dragons and mortals. Battle fearsome dragonspawn, negotiate with warring factions, and ultimately decide the fate of the realm. With an estimated duration of 50 hours, this campaign is ideal for players who enjoy strategic combat and epic storytelling.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Clockwork Conspiracy', 'Steampunk Adventure', 'Investigation and Intrigue', 70, 3, 'Advanced', 'Step into a world of gears and gadgets in "The Clockwork Conspiracy." As a group of three advanced adventurers, you will unravel a web of intrigue that threatens to engulf the steampunk city of Gearhaven. Investigate mysterious disappearances, navigate the city\'s intricate clockwork mechanisms, and uncover a secret society\'s plot to seize control. With an estimated duration of 70 hours, this campaign offers a blend of investigation, puzzle-solving, and political intrigue, making it perfect for players who enjoy a richly detailed and immersive steampunk setting.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Forgotten Realms: A Journey Through Time', 'Fantasy', 'Story-Driven', 120, 4, 'Intermediate', 'Embark on an epic journey through the Forgotten Realms, a land of magic and mystery. Your party will travel through time, witnessing key events that shaped the realm and facing challenges that will test your courage and determination. Unravel the secrets of the past, forge alliances with powerful factions, and make decisions that will alter the course of history. With an estimated duration of 120 hours, this campaign offers a deep and immersive storytelling experience, perfect for a group of four adventurers seeking a rich and rewarding role-playing adventure.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Shadow Wars: Rise of the Dark Lord', 'Dark Fantasy', 'Combat-Heavy', 80, 6, 'Advanced', 'In the Shadow Wars, darkness has engulfed the land as the Dark Lord rises to power. Your party of six advanced adventurers must gather allies, forge alliances, and lead armies into battle against the forces of darkness. Navigate treacherous politics, engage in epic battles, and make decisions that will determine the fate of the realm. With an estimated duration of 80 hours, this campaign offers intense combat, deep storytelling, and moral dilemmas that will challenge even the most seasoned adventurers.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Enchanted Forest: Secrets of the Sylvan Realm', 'Fantasy', 'Exploration', 100, 5, 'Intermediate', "Explore the Enchanted Forest, a mystical realm filled with ancient magic and hidden wonders. Your party of five adventurers will uncover the secrets of the Sylvan Realm, home to mythical creatures and powerful druids. Discover hidden groves, ancient ruins, and magical artifacts as you navigate the forest\"s ever-changing landscape. With an estimated duration of 100 hours, this campaign offers a blend of exploration, puzzle-solving, and role-playing, making it perfect for adventurers seeking a magical and immersive experience.");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The War of the Five Kingdoms: A Game of Thrones', 'Medieval Fantasy', 'Political Intrigue', 90, 6, 'Advanced', 'Enter the world of Westeros in the War of the Five Kingdoms, a game of thrones where alliances are forged and betrayals are commonplace. Your party of six advanced adventurers will navigate the intricate politics of the realm, engage in diplomacy, and lead armies into battle. Choose your allies wisely, for in this game of thrones, the winner takes all. With an estimated duration of 90 hours, this campaign offers a complex and immersive political intrigue, perfect for players who enjoy strategy and diplomacy in their role-playing games.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Age of Heroes: Legends Reborn', 'Fantasy', 'Epic Adventure', 120, 5, 'Intermediate', 'Relive the Age of Heroes in Legends Reborn, a campaign of epic proportions where heroes are born and legends are forged. Your party of five adventurers will embark on a quest to uncover the lost artifacts of the ancient heroes, facing mythical beasts, ancient curses, and rival adventurers along the way. Discover the true meaning of heroism as you journey through vast landscapes, ancient ruins, and mystical realms. With an estimated duration of 120 hours, this campaign offers a grand adventure, perfect for players who seek epic quests and legendary deeds.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Isle of Mysteries: Secrets of the Lost Civilization', 'Adventure', 'Exploration', 80, 4, 'Intermediate', "Embark on a journey to the Isle of Mysteries, a land shrouded in legend and myth. Your party of four adventurers will explore ancient ruins, uncover hidden treasures, and decipher cryptic clues left behind by a lost civilization. Discover the island\"s secrets, solve its mysteries, and uncover the truth of its downfall. With an estimated duration of 80 hours, this campaign offers a blend of exploration, puzzle-solving, and role-playing, perfect for players who seek adventure and discovery in a richly detailed setting.");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ("The Dragon\"s Curse: A Tale of Vengeance", 'Fantasy', 'Combat-Heavy', 70, 5, 'Intermediate', "Venture into the heart of darkness in The Dragon\"s Curse, a campaign of vengeance and redemption. Your party of five adventurers will track down the ancient dragon that laid waste to your homeland, battling through its lair and facing off against its minions. Seek allies among the realm\'s factions, uncover the dragon\"s weaknesses, and prepare for a final showdown that will determine the fate of your people. With an estimated duration of 70 hours, this campaign offers intense combat, deep storytelling, and moral choices that will test your resolve.");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Elemental War: Rise of the Titans', 'Fantasy', 'Epic Adventure', 100, 6, 'Advanced', 'Prepare for the Elemental War, a cataclysmic conflict that will shape the fate of the world. Your party of six advanced adventurers will journey to the four elemental realms, battling titans, harnessing elemental magic, and forging alliances with elemental beings. Uncover the truth behind the war, seek out legendary artifacts, and confront the titans in epic battles that will determine the balance of power in the world. With an estimated duration of 100 hours, this campaign offers epic quests, world-shaping decisions, and legendary battles.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ("The Pirate\"s Cove: Plunder and Peril", 'Adventure', 'Pirate', 60, 4, 'Intermediate', "Sail the high seas in The Pirate\"s Cove, a campaign of swashbuckling adventure and high-seas hijinks. Your party of four adventurers will join a crew of pirates, navigate treacherous waters, and plunder hidden treasure troves. Battle rival pirates, explore deserted islands, and build your pirate empire. With an estimated duration of 60 hours, this campaign offers thrilling pirate-themed adventures, perfect for players who seek excitement and danger on the open seas.");

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ("The Clockwork Kingdom: A Steampunk Adventure", 'Steampunk', 'Investigation and Intrigue', 90, 5, 'Intermediate", "Enter the Clockwork Kingdom, a realm of gears, gadgets, and mystery. Your party of five adventurers will unravel a conspiracy that threatens to destabilize the kingdom, delving into its clockwork mechanisms, navigating its political landscape, and uncovering a plot that reaches to the highest levels of society. With an estimated duration of 90 hours, this campaign offers a blend of investigation, puzzle-solving, and political intrigue, perfect for players who enjoy a steampunk setting and a richly detailed storyline.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Feywild Chronicles: Secrets of the Faerie Realm', 'Fantasy', 'Exploration', 120, 4, 'Intermediate', 'Explore the enchanting realm of the Feywild in this epic campaign. Your party of four adventurers will journey through mystical forests, shimmering lakes, and ancient ruins, encountering faeries, elves, and other magical beings. Uncover the secrets of the faerie realm, solve ancient mysteries, and discover your true destiny. With an estimated duration of 120 hours, this campaign offers a rich and immersive exploration experience, perfect for players who seek adventure in a magical world.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Elemental Planes: A Journey Across Realms', 'Fantasy', 'Epic Adventure', 100, 5, 'Advanced', 'Embark on a journey across the elemental planes in this epic campaign. Your party of five adventurers will travel through the planes of fire, water, air, and earth, facing elemental creatures, ancient guardians, and powerful elemental lords. Uncover the mysteries of the elemental planes, harness elemental magic, and prevent a cataclysm that threatens to engulf the multiverse. With an estimated duration of 100 hours, this campaign offers epic quests, world-shaping decisions, and legendary battles.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Crystal Caverns: Guardians of the Crystals', 'Fantasy', 'Combat-Heavy', 80, 6, 'Intermediate', 'Delve into the Crystal Caverns, a labyrinthine network of caves filled with shimmering crystals and deadly creatures. Your party of six adventurers will battle through hordes of monsters, navigate treacherous terrain, and uncover the secrets of the ancient guardians who protect the crystals. With an estimated duration of 80 hours, this campaign offers intense combat, strategic challenges, and the chance to unearth untold riches.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Dark Forest: Curse of the Werewolf', 'Horror', 'Survival', 60, 4, 'Intermediate', 'Enter the Dark Forest, a place of ancient curses and supernatural horrors. Your party of four adventurers will face werewolves, vampires, and other creatures of the night as you seek to lift the curse that plagues the land. Survive the night, uncover the truth behind the curse, and restore peace to the forest. With an estimated duration of 60 hours, this campaign offers a thrilling and terrifying survival experience, perfect for players who enjoy horror-themed adventures.');

INSERT INTO campaign (name, theme, gameplayStyle, estimatedDuration, partySize, level, summary)
VALUES ('The Celestial War: Rise of the Archangels', 'Fantasy', 'Epic Adventure', 120, 5, 'Advanced', 'Join the celestial war in this epic campaign of divine conflict. Your party of five advanced adventurers will take on the role of archangels, battling demons, fallen angels, and other celestial beings in a struggle for the fate of the heavens. Uncover the secrets of the celestial realms, forge alliances with divine beings, and lead your armies to victory. With an estimated duration of 120 hours, this campaign offers epic battles, divine quests, and the chance to become a legend in the celestial war.');


-----------

INSERT INTO attributes (strength, dexterity, constitution, intelligence, wisdom, charisma)
VALUES (16, 14, 15, 10, 12, 8);

INSERT INTO attributes (strength, dexterity, constitution, intelligence, wisdom, charisma)
VALUES (10, 16, 14, 12, 8, 15);

-----------

INSERT INTO attributes (strength, dexterity, constitution, intelligence, wisdom, charisma)
VALUES (18, 14, 16, 10, 12, 8);

INSERT INTO attributes (strength, dexterity, constitution, intelligence, wisdom, charisma)
VALUES (10, 16, 14, 12, 8, 15);

-----------

INSERT INTO dnd_characters (hit_points, name, race, character_class, level, xp, hits, armor_class, speed, attributes_id)
VALUES (30, "Grog', 'Half-Orc', 'Barbarian', 5, 0, 10, 16, 30, 1);

INSERT INTO dnd_characters (hit_points, name, race, character_class, level, xp, hits, armor_class, speed, attributes_id)
VALUES (25,  'Elara', 'High Elf', 'Wizard', 4, 0, 8, 12, 25, 2);

-----------

INSERT INTO users (name, recommend_new_from_history, recommend_new_from_preference, recommend_new_from_wishlist)
VALUES ('Neca Pereca', false, false, false);

INSERT INTO users (name, recommend_new_from_history, recommend_new_from_preference, recommend_new_from_wishlist)
VALUES ('Rudy Star', false, false, false);

-----------

INSERT INTO ratings (campaign_id, timestamp, rating)
VALUES (1, '2024-06-01 10:00:00', 4);

INSERT INTO ratings (campaign_id, timestamp, rating)
VALUES (2, '2024-06-02 11:00:00', 5);


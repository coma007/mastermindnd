package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.events.AddCampaignEvent;
import com.ftn.sbnz.model.events.ThemeQuery;
import com.ftn.sbnz.model.events.enums.AddCampaignType;
import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.CampaignTheme;
import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.model.models.enums.GameplayStyle;
import com.ftn.sbnz.model.models.enums.Level;
import com.ftn.sbnz.model.models.enums.Theme;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.SessionClock;
import org.kie.api.time.SessionPseudoClock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class CEPConfigTest {

    @Test
    public void testLevel() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");
        SessionClock clock = ksession.getSessionClock();


        User u = new User("nemanja", "123");
        ksession.insert(u);
        ksession.insert(u.getWishlist());
        ksession.insert(u.getPreference());
        ksession.insert(u.getHistory());
        Campaign c1 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.HARD, "Ovo je moja nova prekul kampanja");
        Campaign c2 = new Campaign("Nova kampanja 1", Theme.HISTORICAL, GameplayStyle.PUZZLE_SOLVING_AND_ENVIRONMENTAL_CHALLENGES, Long.parseLong("70"), 4, Level.HARD, "Ovo je moja nova prekul kampanja");
        Campaign c3 = new Campaign("Nova kampanja 1", Theme.WAR, GameplayStyle.ROLE_PLAYING_AND_CHARACTER_DRIVEN, Long.parseLong("70"), 4, Level.HARD, "Ovo je moja nova prekul kampanja");
        ksession.insert(c1);
        ksession.insert(c2);
        ksession.insert(c3);
        AddCampaignEvent e1 = new AddCampaignEvent(Long.parseLong("1"), c1, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        AddCampaignEvent e2 = new AddCampaignEvent(Long.parseLong("1"), c2, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        AddCampaignEvent e3 = new AddCampaignEvent(Long.parseLong("1"), c3, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        ksession.insert(e1);
        ksession.insert(e2);
        ksession.insert(e3);


        ksession.fireAllRules();

        assert u.getHistory().isRecommendedThisMonth();
        assert u.getRecommendedCampaigns().size() == 1;
    }

    @Test
    public void testTheme() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");
        SessionClock clock = ksession.getSessionClock();

        User u = new User("nemanja", "123");
        ksession.insert(u);
        ksession.insert(u.getWishlist());
        ksession.insert(u.getPreference());
        ksession.insert(u.getHistory());
        Campaign c1 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.EASY, "Ovo je moja nova prekul kampanja");
        Campaign c2 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.PUZZLE_SOLVING_AND_ENVIRONMENTAL_CHALLENGES, Long.parseLong("70"), 4, Level.HARD, "Ovo je moja nova prekul kampanja");
        Campaign c3 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.ROLE_PLAYING_AND_CHARACTER_DRIVEN, Long.parseLong("70"), 4, Level.MEDIUM, "Ovo je moja nova prekul kampanja");
        ksession.insert(c1);
        ksession.insert(c2);
        ksession.insert(c3);
        AddCampaignEvent e1 = new AddCampaignEvent(Long.parseLong("1"), c1, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        AddCampaignEvent e2 = new AddCampaignEvent(Long.parseLong("1"), c2, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        AddCampaignEvent e3 = new AddCampaignEvent(Long.parseLong("1"), c3, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        ksession.insert(e1);
        ksession.insert(e2);
        ksession.insert(e3);

        ksession.fireAllRules();

        assert u.getHistory().isRecommendedThisMonth();
        assert u.getRecommendedCampaigns().size() == 1;
    }

    @Test
    public void testStyle() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");
        SessionClock clock = ksession.getSessionClock();

        User u = new User("nemanja", "123");
        ksession.insert(u);
        ksession.insert(u.getWishlist());
        ksession.insert(u.getPreference());
        ksession.insert(u.getHistory());
        Campaign c1 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.EASY, "Ovo je moja nova prekul kampanja");
        Campaign c2 = new Campaign("Nova kampanja 1", Theme.HISTORICAL, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.HARD, "Ovo je moja nova prekul kampanja");
        Campaign c3 = new Campaign("Nova kampanja 1", Theme.WAR, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.MEDIUM, "Ovo je moja nova prekul kampanja");
        ksession.insert(c1);
        ksession.insert(c2);
        ksession.insert(c3);
        AddCampaignEvent e1 = new AddCampaignEvent(Long.parseLong("1"), c1, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        AddCampaignEvent e2 = new AddCampaignEvent(Long.parseLong("1"), c2, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        AddCampaignEvent e3 = new AddCampaignEvent(Long.parseLong("1"), c3, u, AddCampaignType.PLAY, new Date(clock.getCurrentTime()));
        ksession.insert(e1);
        ksession.insert(e2);
        ksession.insert(e3);
        ksession.fireAllRules();

        assert u.getHistory().isRecommendedThisMonth();
        assert u.getRecommendedCampaigns().size() == 1;
    }

    @Test
    public void testNewCampaign() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("userActivity");
        SessionClock clock = ksession.getSessionClock();

        User u = new User("nemanja", "123");
        Campaign c1 = new Campaign("Nova kampanja 1", Theme.FANTASY, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 4, Level.EASY, "Ovo je moja nova prekul kampanja");
        ksession.insert(c1);
        u.getPreference().addCampaign(c1);
        ksession.insert(u);
        ksession.insert(u.getWishlist());
        ksession.insert(u.getPreference());
        ksession.insert(u.getHistory());
        AddCampaignEvent e1 = new AddCampaignEvent(Long.parseLong("1"), c1, u, AddCampaignType.LIKE, new Date(clock.getCurrentTime()));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        ksession.insert(e1);

        Campaign c4 = new Campaign("Nova kampanja 4", Theme.FANTASY, GameplayStyle.COMBAT_FOCUSED, Long.parseLong("70"), 10, Level.HARD, "Ovo je moja novija prekul kampanja");
        ksession.insert(c4);

        ksession.fireAllRules();

         assert u.getRecommendedCampaigns().size() == 2;

    }

    @Test
    public void testThemes() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession ksession = kContainer.newKieSession("themeFinder");
        SessionClock clock = ksession.getSessionClock();

        User u = new User("nemanja", "123");
        ksession.insert(u);
        ksession.insert(u.getWishlist());
        ksession.insert(u.getPreference());
        ksession.insert(u.getHistory());
        CampaignTheme ct0 = new CampaignTheme("Voldemort attacks", "HP");
        CampaignTheme ct1 = new CampaignTheme("HP", "Film");
        CampaignTheme ct2 = new CampaignTheme("Film", Theme.FANTASY.toString());
        ksession.insert(ct0);
        ksession.insert(ct1);
        ksession.insert(ct2);
        ThemeQuery e1 = new ThemeQuery(Long.parseLong("1"), "Voldemort attacks", Theme.FANTASY, new Date(clock.getCurrentTime()));
        ksession.insert(e1);
        List<String> results = new ArrayList<>();
        ksession.setGlobal("results", results);

        ksession.fireAllRules();
        System.out.println(results.size());
    }
}

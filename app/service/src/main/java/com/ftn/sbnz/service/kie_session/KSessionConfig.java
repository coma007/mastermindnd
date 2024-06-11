package com.ftn.sbnz.service.kie_session;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableTransactionManagement
public class KSessionConfig {

    private KieContainer kieContainer;

    @Autowired
    public KSessionConfig(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    @Bean
    public KieSession kieSession() {
        SessionBuilder sessionBuilder = new SessionBuilder();
        sessionBuilder.addRules("./kjar/src/main/resources/rules/userActivity/userActivity.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/forward/comment.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/forward/watched.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/forward/wishlist.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/cep/cep_genre_recommendation.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/cep/cep_global_recommendation.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/backward/backward.drl");
//        sessionBuilder.addRules("./kjar/src/main/resources/rules/query/query.drl");
        sessionBuilder.addTemplate("./kjar/src/main/resources/rules/templates/activity.drt", "./kjar/src/main/resources/rules/templates/activity.xlsx");
        sessionBuilder.addTemplate("./kjar/src/main/resources/rules/templates/recommendation.drt", "./kjar/src/main/resources/rules/templates/recommendation.xlsx");
//
        return sessionBuilder.build();

//        return kieContainer.newKieSession("userActivity");
    }
    @Bean
    public KieSession kieSessionTheme() {

        return kieContainer.newKieSession("themeFinder");
    }
}

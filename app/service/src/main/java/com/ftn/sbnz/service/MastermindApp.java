package com.ftn.sbnz.service;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ftn.sbnz.*" })
@EntityScan("com.ftn.sbnz.*")
@EnableJpaRepositories("com.ftn.sbnz.*")
public class MastermindApp {
    public static void main(String[] args) {
        SpringApplication.run(MastermindApp.class, args);
    }

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(1000);
        return kContainer;
    }

//    @Bean
//    public KieSession getUserActivityKieSession() {
//    KieServices ks = KieServices.Factory.get();
//    KieContainer kContainer = ks.getKieClasspathContainer();
//    KieSession ksession = kContainer.newKieSession("userActivity");
//    return ksession;
//    }
}


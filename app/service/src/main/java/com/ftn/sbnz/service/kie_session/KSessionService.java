package com.ftn.sbnz.service.kie_session;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
@Scope("singleton")
public class KSessionService {
    private KieSession userActivitySession;

    @PostConstruct
    public void initializeSession() {
        createUserActivitySession();
    }

    public KieSession getUserActivitySession(){
        if(userActivitySession == null){
            createUserActivitySession();
        }
        System.out.println(userActivitySession);
        return userActivitySession;
    }

    public void resetUserActivitySession() {
        if (userActivitySession != null) {
            userActivitySession.dispose();
        }
        createUserActivitySession();
    }

    private void createUserActivitySession(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        this.userActivitySession = kContainer.newKieSession("userActivity");
    }
}
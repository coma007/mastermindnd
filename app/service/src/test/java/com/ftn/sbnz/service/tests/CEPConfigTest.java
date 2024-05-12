package com.ftn.sbnz.service.tests;

import com.ftn.sbnz.model.models.Transaction;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.SessionClock;
import org.kie.api.time.SessionPseudoClock;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class CEPConfigTest {

    @Test
    public void test() {
         KieServices ks = KieServices.Factory.get();
         KieContainer kContainer = ks.getKieClasspathContainer();
         KieSession ksession = kContainer.newKieSession("cepKsession");

    }
}

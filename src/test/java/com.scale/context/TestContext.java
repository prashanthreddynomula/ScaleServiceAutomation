package com.scale.context;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import com.scale.framework.utility.*;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;


public class TestContext {

    private Logger log = Log.getLogger(TestContext.class);
    public Scenario scenario;
    public ScenarioContext scenarioContext;
    private JSONUtility jsonUtilityObj;
    private ConfigurationReader configReader;


    @Before
    public void setUp(Scenario scenario) throws MalformedURLException {
        // log.info("=================" + scenario.getName() + " execution starts" + "===================");
        this.scenario = scenario;
        jsonUtilityObj = new JSONUtility();
        scenarioContext = new ScenarioContext();
        configReader = new ConfigurationReader();
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
    }


    @After
    public void cleanUp() throws Exception {
        log.info("=================" + scenario.getName() + " execution ends" + "===================");

        if (scenarioContext != null) {
            scenarioContext.clearContext();
        }

    }

    public JSONUtility getJsonUtilityObj() {
        return jsonUtilityObj;
    }


}

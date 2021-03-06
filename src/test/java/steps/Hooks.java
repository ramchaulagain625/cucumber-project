package steps;

import Utils.commonMethod;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends commonMethod {
    Scenario scenario;
    @Before
    public void start(Scenario s){
        setUp();
        scenario=s;
    }

    @After
    public void end(Scenario scenario){
        byte[]pic;
        if(scenario.isFailed()){
            pic=takeScreenshot("failed/"+ scenario.getName());
        }else{
            pic=takeScreenshot("passed/"+ scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());

        teardown();
    }
}

package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = { "com.stepDefinitions", "com.hooks" }, 
		plugin = { "pretty",
				"html:target/cucumber-report.html", "json:target/cucumber-report.json",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failedrerun.txt" },


		
        tags="@AccountFeature",



	            
       

       

        
        
=======
>>>>>>> 96d9079cdde2ed4463588d7ec9cafed5a9ba3589

        monochrome = true
)



public class TestNgRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

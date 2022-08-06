package com.BDD.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:features",
		glue="com.BDD.automation.stepdefs",
		tags=" @Validate_prodcategory",
		plugin={ "pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/jsonreport.json"
		},
		dryRun=false,
		monochrome =true,
		publish=true
		)



public class TestRunner {
	

}

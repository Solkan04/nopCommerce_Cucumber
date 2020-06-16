package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		/*
		 * To run multiple feature file at once: features=".//Features/"---> runs all
		 * the feature file present in Feature folder features=
		 * {".//Features//Customers_nopcommerce.feature",
		 * ".//Features//Login_nopcommerce.feature"} --->runs only the specified feature
		 * file
		 */
		features = { ".//Features/" }, // it is mandatory keyword-we should specify the
										// path
										// of .feature file
		glue = "stepDefinitions", // we should specify the step definition package name
		dryRun = false, /*
						 * if we set dryRun=true then it'll cross verify whether every step in .feature
						 * file is having corresponding methods implemented or not in step definition
						 */
		monochrome = true, // it'll remove unnecessary characters in our console
		plugin = { "pretty", // if we need to print the output clearly in the console then we use 'pretty'
				"html:target/Test-Output.html" }, // it produces html reports
		tags = "@regression"
		//tags = {"@sanity , @regression"}
		)
public class Runner 
{

}

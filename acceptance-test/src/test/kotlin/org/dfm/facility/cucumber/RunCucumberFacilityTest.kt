package org.dfm.facility.cucumber

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(features = ["classpath:features"], strict = true, plugin = ["json:target/cucumber/facility.json", "json:target/cucumber/facility.xml"], tags = ["@Facility"], glue = ["classpath:org.dfm.facility.cucumber"])
class RunCucumberFacilityTest

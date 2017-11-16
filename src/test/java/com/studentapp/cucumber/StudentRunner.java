package com.studentapp.cucumber;

import com.studentapp.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by magn on 11/16/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resorces\\feature")
public class StudentRunner extends TestBase{
}


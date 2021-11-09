package com.urcar.appliationurcar.test.cucumber;


import com.urcar.appliationurcar.AppliationUrcarApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes= AppliationUrcarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = AppliationUrcarApplication.class, loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {

}

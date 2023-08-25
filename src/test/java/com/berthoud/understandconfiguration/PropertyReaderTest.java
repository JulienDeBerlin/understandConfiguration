package com.berthoud.understandconfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.berthoud.understandconfiguration.AppProperties.Menu;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PropertyReaderTest {

  @Autowired
  PropertyReader underTest;

  @Autowired
  Holiday holiday;

  @Autowired
  AppProperties appProperties;


  @Test
  @DisplayName("inject yaml property through @Value")
  void displayLastLocation() {
    // Preparation

    // Execution
    var result = underTest.getLocationLastHoliday();

    //Assertion
    assertEquals("Bavaria", result);
  }


  @Test
  @DisplayName("use default value when property is not specified")
  void displayNextLocation() {
    // Preparation

    // Execution
    var result = underTest.getLocationNextHoliday();

    //Assertion
    assertEquals("at my parent", result);
  }


  @Test
  @DisplayName("inject env variable through @Value")
  void injectEnvVariableThroughValue() {
    // Preparation

    // Execution
    var result = underTest.getJavaHomeFromEnvVariable();

    //Assertion
    assertEquals("C:\\Program Files\\OpenJDK\\jdk-17.0.2", result);
  }


  @Test
  @DisplayName("value can be mapped to a List")
  void valueCanBeMappedToAList() {
    // Preparation

    // Execution
    var result = underTest.getVisitedCountries();

    //Assertion
    assertThat(result, containsInAnyOrder("Argentina", "Italy", "Spain", "Brazil"));
  }

  @Test
  @DisplayName("test the @ConfigurationProperties annotation")
  @SneakyThrows
  void testTheConfigurationPropertiesAnnotation() {
    // Assertion
    assertAll(
        () -> assertEquals("Bavaria", holiday.getLocation()),
        () -> assertEquals("2023", holiday.getYear()),
        () -> assertEquals("great", holiday.getVerdict())
    );
  }

  @Test
  @DisplayName("test the @ConfigurationProperties annotation with List")
  @SneakyThrows
  void testTheConfigurationPropertiesAnnotationWithList() {
    // Assertion

    assertThat(appProperties.getMenus(), hasItem(new Menu("Home", "/", "Home")));
    assertThat(appProperties.getMenus(), hasItem(new Menu("Login", "/login", "Login")));
    assertThat(appProperties.getMenus(), containsInAnyOrder(new Menu("Login", "/login", "Login"),
        new Menu("Home", "/", "Home")));

  }


}

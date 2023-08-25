package com.berthoud.understandconfiguration;

import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("/additionnalProperties.properties")
public class PropertyReader {

  @Value("${last.holidays.location:Istanbul}")
  String locationLastHoliday;

  @Value("${next.holidays.location:at my parent}")
  String locationNextHoliday;

  @Value("${JAVA_HOME}")
  String javaHomeFromEnvVariable;

  @Value("${countries.visited}")
  private List<String> visitedCountries;

  @Value("${car}")
  private String car;

}

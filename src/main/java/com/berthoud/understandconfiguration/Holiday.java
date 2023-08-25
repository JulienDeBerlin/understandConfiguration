package com.berthoud.understandconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "last.holidays")
@Data
public class Holiday {

  private String location;
  private String year;
  private String verdict;
}

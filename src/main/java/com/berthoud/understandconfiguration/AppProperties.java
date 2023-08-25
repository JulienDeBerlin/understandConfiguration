package com.berthoud.understandconfiguration;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app") // prefix app, find app.* values
@Data
public class AppProperties {

  private String error;
  private List<Menu> menus = new ArrayList<>();
  private Compiler compiler = new Compiler();

  @Data
  @AllArgsConstructor
  public static class Menu {

    private String name;
    private String path;
    private String title;
  }

  @Data
  public static class Compiler {

    private String timeout;
    private String outputFolder;
  }

}

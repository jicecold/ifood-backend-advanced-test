package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

  @JsonProperty("id")
  public Integer id;
  @JsonProperty("main")
  public String main;
  @JsonProperty("description")
  public String description;
  @JsonProperty("icon")
  public String icon;

}

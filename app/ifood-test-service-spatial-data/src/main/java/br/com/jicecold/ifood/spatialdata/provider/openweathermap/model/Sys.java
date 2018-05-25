package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys {

  @JsonProperty("type")
  public Integer type;
  @JsonProperty("id")
  public Integer id;
  @JsonProperty("message")
  public Double message;
  @JsonProperty("country")
  public String country;
  @JsonProperty("sunrise")
  public Integer sunrise;
  @JsonProperty("sunset")
  public Integer sunset;

}

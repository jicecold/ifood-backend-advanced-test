package br.com.jicecold.ifood.spatialdata.provider.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
  @JsonProperty("speed")
  public Double speed;
  @JsonProperty("deg")
  public Integer deg;
}

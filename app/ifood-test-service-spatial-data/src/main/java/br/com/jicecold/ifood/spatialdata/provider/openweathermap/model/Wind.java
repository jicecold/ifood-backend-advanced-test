package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
  @JsonProperty("speed")
  public Double speed;
  @JsonProperty("deg")
  public Integer deg;
}

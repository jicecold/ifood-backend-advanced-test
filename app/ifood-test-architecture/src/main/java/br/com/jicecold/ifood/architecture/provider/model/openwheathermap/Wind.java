package br.com.jicecold.ifood.architecture.provider.model.openwheathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
  @JsonProperty("speed")
  public Double speed;
  @JsonProperty("deg")
  public Integer deg;
}

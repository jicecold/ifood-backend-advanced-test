package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {

  @JsonProperty("lon")
  public Double lon;
  @JsonProperty("lat")
  public Double lat;

}

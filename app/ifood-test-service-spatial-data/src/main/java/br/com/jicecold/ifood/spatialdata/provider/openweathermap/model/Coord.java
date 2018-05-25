package br.com.jicecold.ifood.spatialdata.provider.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Coord {

  @JsonProperty("lon")
  private Double lon;
  @JsonProperty("lat")
  private Double lat;

}

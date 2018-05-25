package br.com.jicecold.ifood.spatialdata.provider.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Sys {

  @JsonProperty("type")
  private Integer type;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("message")
  private Double message;
  @JsonProperty("country")
  private String country;
  @JsonProperty("sunrise")
  private Integer sunrise;
  @JsonProperty("sunset")
  private Integer sunset;

}

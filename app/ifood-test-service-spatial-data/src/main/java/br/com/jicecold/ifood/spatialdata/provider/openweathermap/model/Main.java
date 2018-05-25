package br.com.jicecold.ifood.spatialdata.provider.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {

  @JsonProperty("temp")
  private Double temp;
  @JsonProperty("pressure")
  private Integer pressure;
  @JsonProperty("humidity")
  private Integer humidity;
  @JsonProperty("temp_min")
  private Double tempMin;
  @JsonProperty("temp_max")
  private Double tempMax;

}

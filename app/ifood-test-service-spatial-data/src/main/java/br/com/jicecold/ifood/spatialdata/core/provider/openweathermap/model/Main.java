package br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Main {
  private Double temp;
  @JsonProperty("temp_min")
  private Double tempMin;
  @JsonProperty("temp_max")
  private Double tempMax;
}

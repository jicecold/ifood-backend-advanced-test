package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main {

  @JsonProperty("temp")
  public Double temp;
  @JsonProperty("pressure")
  public Integer pressure;
  @JsonProperty("humidity")
  public Integer humidity;
  @JsonProperty("temp_min")
  public Double tempMin;
  @JsonProperty("temp_max")
  public Double tempMax;

}

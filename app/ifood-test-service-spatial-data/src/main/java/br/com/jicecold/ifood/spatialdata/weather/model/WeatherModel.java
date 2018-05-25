package br.com.jicecold.ifood.spatialdata.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WeatherModel {

  private String cityName;
  private String country;
  private Double latitude;
  private Double longitude;
  private Double temp;
  private Double tempMin;
  private Double tempMax;

}

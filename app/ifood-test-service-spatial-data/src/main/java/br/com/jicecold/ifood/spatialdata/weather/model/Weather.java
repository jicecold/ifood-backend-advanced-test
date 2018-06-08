package br.com.jicecold.ifood.spatialdata.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

  private String cityName;
  private String country;
  private Double latitude;
  private Double longitude;
  private Double temp;
  private Double tempMin;
  private Double tempMax;

}

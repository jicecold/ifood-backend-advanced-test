package br.com.jicecold.ifood.music.core.provider.spatialdata.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {
  private String cityName;
  private String country;
  private Double latitude;
  private Double longitude;
  private Double temp;
  private Double tempMin;
  private Double tempMax;
}

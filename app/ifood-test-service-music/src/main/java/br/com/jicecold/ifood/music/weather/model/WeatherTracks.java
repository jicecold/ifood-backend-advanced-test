package br.com.jicecold.ifood.music.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherTracks {

  private Double temp;
  private String city;
  private String country;
  private Double latitude;
  private Double longitude;
  private String genre;
  private List<String> songs;

}

package br.com.jicecold.ifood.music.suggest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SongsWeather {

  private Double temp;
  private String city;
  private Double latitude;
  private Double longitude;
  private String genre;
  private List<String> songs;

}

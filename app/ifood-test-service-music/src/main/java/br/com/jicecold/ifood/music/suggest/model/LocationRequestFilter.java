package br.com.jicecold.ifood.music.suggest.model;

import br.com.jicecold.ifood.architecture.generic.model.RequestFilter;
import lombok.Data;

@Data
public class LocationRequestFilter extends RequestFilter {
  private String city;
  private Double latitude;
  private Double longitude;
}

package br.com.jicecold.ifood.music.suggest.model;

import br.com.jicecold.ifood.architecture.generic.model.RequestParamsFilter;
import lombok.Data;

@Data
public class LocationRequestParamsFilter implements RequestParamsFilter {
  private String city;
  private Double latitude;
  private Double longitude;
}

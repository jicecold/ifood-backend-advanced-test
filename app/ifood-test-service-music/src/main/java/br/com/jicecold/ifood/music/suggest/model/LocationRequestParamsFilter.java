package br.com.jicecold.ifood.music.suggest.model;

import br.com.jicecold.ifood.commons.generic.model.RequestParamsFilter;
import lombok.Data;

@Data
public class LocationRequestParamsFilter extends RequestParamsFilter {
  private String city;
  private Double latitude;
  private Double longitude;
}

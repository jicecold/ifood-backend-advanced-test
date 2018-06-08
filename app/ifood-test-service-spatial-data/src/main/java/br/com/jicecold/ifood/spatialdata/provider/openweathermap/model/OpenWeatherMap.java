package br.com.jicecold.ifood.spatialdata.provider.openweathermap.model;

import lombok.Data;

@Data
public class OpenWeatherMap {

  private String name;
  private Coord coord;
  private Main main;
  private Sys sys;

}

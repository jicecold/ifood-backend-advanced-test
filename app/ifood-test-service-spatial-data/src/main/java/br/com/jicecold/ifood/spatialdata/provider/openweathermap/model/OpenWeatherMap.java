package br.com.jicecold.ifood.core.model.openweathermap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenWeatherMap {

  @JsonProperty("coord")
  public Coord coord;
  @JsonProperty("weather")
  public List<Weather> weather = null;
  @JsonProperty("base")
  public String base;
  @JsonProperty("main")
  public Main main;
  @JsonProperty("visibility")
  public Integer visibility;
  @JsonProperty("wind")
  public Wind wind;
  @JsonProperty("clouds")
  public Clouds clouds;
  @JsonProperty("dt")
  public Integer dt;
  @JsonProperty("sys")
  public Sys sys;
  @JsonProperty("id")
  public Integer id;
  @JsonProperty("name")
  public String name;
  @JsonProperty("cod")
  public Integer cod;

}

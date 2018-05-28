package br.com.jicecold.ifood.architecture.provider.model.openwheathermap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenWeatherMap {

  @JsonProperty("coord")
  private Coord coord;
  @JsonProperty("weather")
  private List<Weather> weather = null;
  @JsonProperty("base")
  private String base;
  @JsonProperty("main")
  private Main main;
  @JsonProperty("visibility")
  private Integer visibility;
  @JsonProperty("wind")
  private Wind wind;
  @JsonProperty("clouds")
  private Clouds clouds;
  @JsonProperty("dt")
  private Integer dt;
  @JsonProperty("sys")
  private Sys sys;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("name")
  private String name;
  @JsonProperty("cod")
  private Integer cod;

}

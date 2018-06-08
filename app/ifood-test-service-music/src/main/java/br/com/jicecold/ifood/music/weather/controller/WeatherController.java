package br.com.jicecold.ifood.music.weather.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.weather.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.weather.model.WeatherTracks;
import br.com.jicecold.ifood.music.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController extends BaseController {

  private final WeatherService weatherService;

  @Autowired
  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping("location")
  public ResponseModel<WeatherTracks> suggestMusicByLocation(LocationRequestFilter filter) {
    WeatherTracks data = weatherService.suggestMusicByLocation(filter);
    return ResponseModel.<WeatherTracks>builder()
        .content(data)
        .build();
  }

}

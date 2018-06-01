package br.com.jicecold.ifood.spatialdata.weather.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.spatialdata.weather.model.Weather;
import br.com.jicecold.ifood.spatialdata.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController extends BaseController {

  @Autowired
  private WeatherService weatherService;

  @GetMapping("city")
  public ResponseModel<Weather> getWeatherByCityName(@RequestParam String name){
    Weather data = weatherService.getWeatherByCityName(name);
    return ResponseModel.<Weather>builder()
        .content(data)
        .build();
  }

  @GetMapping("coordinates")
  public ResponseModel<Weather> getWeatherByCoordinates(@RequestParam Double lat,
                                                               @RequestParam Double lon){
    Weather data = weatherService.getWeatherByCoordinates(lat, lon);
    return ResponseModel.<Weather>builder()
        .content(data)
        .build();
  }
}

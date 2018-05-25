package br.com.jicecold.ifood.spatialdata.weather.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.spatialdata.weather.model.WeatherModel;
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
  public WeatherModel getWeatherByCityName(@RequestParam String name){
    return weatherService.getWeatherByCityName(name);
  }

  @GetMapping("coordinates")
  public WeatherModel getWeatherByCoordinates(@RequestParam String lat,
                                               @RequestParam String lon){
    return weatherService.getWeatherByCoordinates(lat, lon);
  }
}

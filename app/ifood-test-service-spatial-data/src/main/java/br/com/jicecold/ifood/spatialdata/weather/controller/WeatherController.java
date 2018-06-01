package br.com.jicecold.ifood.spatialdata.weather.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.commons.spatialdata.model.WeatherResponseModel;
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
  public WeatherResponseModel<Weather> getWeatherByCityName(@RequestParam String name){
    WeatherResponseModel<Weather> response = new WeatherResponseModel<>();
    Weather data = weatherService.getWeatherByCityName(name);
    response.setData(data);
    return response;
  }

  @GetMapping("coordinates")
  public WeatherResponseModel<Weather> getWeatherByCoordinates(@RequestParam Double lat,
                                                               @RequestParam Double lon){
    WeatherResponseModel<Weather> response = new WeatherResponseModel<>();
    Weather data = weatherService.getWeatherByCoordinates(lat, lon);
    response.setData(data);
    return response;
  }
}

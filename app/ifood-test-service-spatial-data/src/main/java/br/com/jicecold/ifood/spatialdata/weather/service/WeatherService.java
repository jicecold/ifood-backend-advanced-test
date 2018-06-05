package br.com.jicecold.ifood.spatialdata.weather.service;

import br.com.jicecold.ifood.spatialdata.provider.openweathermap.OpenWeatherMapProvider;
import br.com.jicecold.ifood.spatialdata.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final OpenWeatherMapProvider openWeatherMapProvider;

  @Autowired
  public WeatherService(OpenWeatherMapProvider openWeatherMapProvider) {
    this.openWeatherMapProvider = openWeatherMapProvider;
  }

  public Weather getWeatherByCityName(String name) {
    return openWeatherMapProvider.findWeatherByCityName(name);
  }

  public Weather getWeatherByCoordinates(Double lat, Double lon) {
    return openWeatherMapProvider.findWeatherByCoordinates(lat, lon);
  }
}

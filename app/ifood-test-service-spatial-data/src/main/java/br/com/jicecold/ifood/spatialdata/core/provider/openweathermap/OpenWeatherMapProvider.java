package br.com.jicecold.ifood.spatialdata.core.provider.openweathermap;

import br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.client.OpenWeatherMapClient;
import br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.model.OpenWeatherMap;
import br.com.jicecold.ifood.spatialdata.core.converter.OpenWeatherMapConverter;
import br.com.jicecold.ifood.spatialdata.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapProvider {

  @Value("${openweathermap.api.units}")
  private String units;

  @Autowired
  private OpenWeatherMapClient openWeatherMapClient;

  @Autowired
  private OpenWeatherMapConverter openWeatherMapConverter;

  public Weather findWeatherByCityName(String name) {
    OpenWeatherMap weather = openWeatherMapClient.search(name, units);
    return openWeatherMapConverter.convertFrom(weather);
  }

  public Weather findWeatherByCoordinates(Double latitude, Double longitude) {
    OpenWeatherMap weather = openWeatherMapClient.findByCoordinates(latitude, longitude, units);
    return openWeatherMapConverter.convertFrom(weather);
  }

}

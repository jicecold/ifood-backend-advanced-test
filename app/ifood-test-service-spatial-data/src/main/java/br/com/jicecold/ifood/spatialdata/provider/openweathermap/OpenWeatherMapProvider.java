package br.com.jicecold.ifood.spatialdata.provider.openweathermap;

import br.com.jicecold.ifood.spatialdata.converter.OpenWeatherMapConverter;
import br.com.jicecold.ifood.spatialdata.provider.openweathermap.client.OpenWeatherMapClient;
import br.com.jicecold.ifood.spatialdata.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherMapProvider {

  private final OpenWeatherMapContext openWeatherMapContext;
  private final OpenWeatherMapClient openWeatherMapClient;
  private final OpenWeatherMapConverter openWeatherMapConverter;

  @Autowired
  public OpenWeatherMapProvider(OpenWeatherMapContext openWeatherMapContext,
                                OpenWeatherMapClient openWeatherMapClient,
                                OpenWeatherMapConverter openWeatherMapConverter) {
    this.openWeatherMapContext = openWeatherMapContext;
    this.openWeatherMapClient = openWeatherMapClient;
    this.openWeatherMapConverter = openWeatherMapConverter;
  }

  public Weather findWeatherByCityName(String name) {
    return openWeatherMapConverter
        .convertFrom(openWeatherMapClient
            .search(name, openWeatherMapContext.getUnits()));
  }

  public Weather findWeatherByCoordinates(Double latitude, Double longitude) {
    return openWeatherMapConverter
        .convertFrom(openWeatherMapClient
            .findByCoordinates(latitude, longitude, openWeatherMapContext.getUnits()));
  }
}

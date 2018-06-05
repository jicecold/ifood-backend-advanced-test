package br.com.jicecold.ifood.spatialdata.core.converter;

import br.com.jicecold.ifood.architecture.generic.converter.Converter;
import br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.model.OpenWeatherMap;
import br.com.jicecold.ifood.spatialdata.weather.model.Weather;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapConverter extends Converter<OpenWeatherMap, Weather> {

  public OpenWeatherMapConverter() {
    super(source -> Weather.builder()
        .tempMin(source.getMain().getTempMin())
        .temp(source.getMain().getTemp())
        .tempMax(source.getMain().getTempMax())
        .longitude(source.getCoord().getLon())
        .latitude(source.getCoord().getLat())
        .country(source.getSys().getCountry())
        .cityName(source.getName())
        .build());
  }

}

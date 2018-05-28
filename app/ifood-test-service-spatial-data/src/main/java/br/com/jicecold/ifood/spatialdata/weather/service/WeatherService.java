package br.com.jicecold.ifood.spatialdata.weather.service;

import br.com.jicecold.ifood.architecture.provider.OpenWeatherMapProvider;
import br.com.jicecold.ifood.architecture.provider.model.openwheathermap.OpenWeatherMap;
import br.com.jicecold.ifood.spatialdata.weather.model.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  @Autowired
  private OpenWeatherMapProvider openWeatherMapProvider;

  public WeatherModel getWeatherByCityName(String name){
    OpenWeatherMap weatherByCityName = openWeatherMapProvider.getWeatherByCityName(name);
    return createResponseModel(weatherByCityName);
  }

  public WeatherModel getWeatherByCoordinates(String lat, String lon){
    OpenWeatherMap weatherByCityName = openWeatherMapProvider.getWeatherByCoordinates(lat, lon);
    return createResponseModel(weatherByCityName);
  }

  private WeatherModel createResponseModel(OpenWeatherMap weatherByCityName){
    return WeatherModel.builder()
        .cityName(weatherByCityName.getName())
        .country(weatherByCityName.getSys().getCountry())
        .temp(weatherByCityName.getMain().getTemp())
        .tempMax(weatherByCityName.getMain().getTempMax())
        .tempMin(weatherByCityName.getMain().getTempMin())
        .latitude(weatherByCityName.getCoord().getLat())
        .longitude(weatherByCityName.getCoord().getLon())
        .build();
  }

}

package br.com.jicecold.ifood.spatialdata.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenWeatherMapProvider {

  private RestTemplate restTemplate;

  public OpenWeather getWeatherByCityName(String name) {

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherProperties.getUrl());

    builder.queryParam("q", name);
    builder.queryParam("units", "metric");
    builder.queryParam("APPID", "3445a9ae08df1a3117ae58bdfa7cda3d");

    OpenWeather response = restTemplate.getForObject(builder.buildAndExpand().toUri(), OpenWeather.class);

    return response;
  }

  public OpenWeather getWeatherByLatLong(Double latitude, Double longitude) {

    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherProperties.getUrl());

    builder.queryParam("lat", latitude);
    builder.queryParam("lon", longitude);
    builder.queryParam("units", "metric");
    builder.queryParam("APPID", "3445a9ae08df1a3117ae58bdfa7cda3d");

    OpenWeather response = restTemplate.getForObject(builder.buildAndExpand().toUri(), OpenWeather.class);

    return response;
  }

}

package br.com.jicecold.ifood.spatialdata.provider.openweathermap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class OpenWeatherMapConfig {

  private final String appId;

  public OpenWeatherMapConfig(@Value("${openweathermap.api.appid}") String appId) {
    this.appId = appId;
  }

  @Bean
  public OpenWeatherMapRequestInterceptor openWeatherMapRequestInterceptor(){
    return new OpenWeatherMapRequestInterceptor(appId);
  }
}

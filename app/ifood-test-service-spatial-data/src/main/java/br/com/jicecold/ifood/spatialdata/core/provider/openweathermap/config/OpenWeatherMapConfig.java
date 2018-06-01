package br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.config;

import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenWeatherMapConfig {

  @Autowired
  private OpenWeatherMapRequestInterceptor openWeatherMapRequestInterceptor;

  @Bean
  public Feign.Builder builder() {
    return new Feign.Builder()
        .logLevel(Logger.Level.FULL)
        .requestInterceptor(openWeatherMapRequestInterceptor);
  }
}

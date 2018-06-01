package br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapRequestInterceptor implements RequestInterceptor {

  public static final String APP_ID = "APPID";

  @Value("${openweathermap.api.appid}")
  private String appId;

  @Override
  public void apply(RequestTemplate template) {
    template.query(APP_ID, appId);
  }
}

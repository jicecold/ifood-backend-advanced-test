package br.com.jicecold.ifood.spatialdata.provider.openweathermap.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class OpenWeatherMapRequestInterceptor implements RequestInterceptor {

  public static final String APP_ID = "APPID";

  private final String appId;

  public OpenWeatherMapRequestInterceptor( String appId) {
    this.appId = appId;
  }

  @Override
  public void apply(RequestTemplate template) {
    template.query(APP_ID, appId);
  }
}

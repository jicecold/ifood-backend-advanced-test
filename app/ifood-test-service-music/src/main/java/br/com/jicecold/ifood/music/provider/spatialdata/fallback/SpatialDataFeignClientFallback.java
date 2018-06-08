package br.com.jicecold.ifood.music.provider.spatialdata.fallback;

import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.provider.spatialdata.client.SpatialDataFeignClient;
import br.com.jicecold.ifood.music.provider.spatialdata.model.Weather;
import org.springframework.stereotype.Component;

@Component
public class SpatialDataFeignClientFallback implements SpatialDataFeignClient {

  @Override
  public ResponseModel<Weather> getWeatherByCityName(String name) {
    return createDefaultResponse();
  }

  @Override
  public ResponseModel<Weather> getWeatherByCoodinates(Double latitude, Double longitude) {
    return createDefaultResponse();
  }

  private ResponseModel<Weather> createDefaultResponse() {
    return ResponseModel.<Weather>builder()
        .content(Weather.builder()
            .cityName("Campinas")
            .country("BR")
            .latitude(-22.9056)
            .longitude(-47.0609)
            .temp(14.1)
            .tempMax(30.0)
            .tempMin(20.0)
            .build())
        .build();
  }

}

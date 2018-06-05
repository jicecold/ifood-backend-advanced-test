package br.com.jicecold.ifood.music.provider.spatialdata;

import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.provider.spatialdata.client.SpatialDataFeignClient;
import br.com.jicecold.ifood.music.provider.spatialdata.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpatialDataProvider {

  @Autowired
  private SpatialDataFeignClient spatialDataFeignClient;

  public Weather getWeatherByCityName(String cityName) {
    ResponseModel<Weather> responseModel = spatialDataFeignClient.getWeatherByCityName(cityName);
    return responseModel.getContent();
  }

  public Weather getWeatherByCoodinates(Double latitude, Double longitude) {
    ResponseModel<Weather> responseModel = spatialDataFeignClient.getWeatherByCoodinates(latitude, longitude);
    return responseModel.getContent();
  }

}

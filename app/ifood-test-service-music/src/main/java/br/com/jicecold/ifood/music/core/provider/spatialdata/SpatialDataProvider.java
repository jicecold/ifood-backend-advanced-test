package br.com.jicecold.ifood.music.core.provider.spatialdata;

import br.com.jicecold.ifood.commons.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.core.provider.spatialdata.client.SpatialDataClient;
import br.com.jicecold.ifood.music.core.provider.spatialdata.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpatialDataProvider {

  @Autowired
  private SpatialDataClient spatialDataClient;

  public Weather getWeatherByCityName(String cityName){
    ResponseModel<Weather> responseModel = spatialDataClient.getWeatherByCityName(cityName);
    return responseModel.getData();
  }

  public Weather getWeatherByCoodinates(Double latitude, Double longitude){
    ResponseModel<Weather> responseModel = spatialDataClient.getWeatherByCoodinates(latitude, longitude);
    return responseModel.getData();
  }

}

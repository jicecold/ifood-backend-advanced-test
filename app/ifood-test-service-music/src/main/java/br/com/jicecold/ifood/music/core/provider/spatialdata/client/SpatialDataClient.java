package br.com.jicecold.ifood.music.core.provider.spatialdata.client;

import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.core.provider.spatialdata.model.Weather;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ifood-test-service-spatial-data")
public interface SpatialDataClient {

  @GetMapping(value = "/spatial-data/weather/city")
  ResponseModel<Weather> getWeatherByCityName(@RequestParam(name = "name") String name);

  @GetMapping(value = "/spatial-data/weather/coordinates")
  ResponseModel<Weather> getWeatherByCoodinates(@RequestParam(name = "lat") Double latitude,
                                                @RequestParam(name = "lon") Double longitude);

}

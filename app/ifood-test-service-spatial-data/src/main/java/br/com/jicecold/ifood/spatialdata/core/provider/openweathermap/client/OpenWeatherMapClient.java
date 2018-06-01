package br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.client;

import br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.config.OpenWeatherMapConfig;
import br.com.jicecold.ifood.spatialdata.core.provider.openweathermap.model.OpenWeatherMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${openweathermap.name}", url = "${openweathermap.api.url}",
    configuration = OpenWeatherMapConfig.class)
public interface OpenWeatherMapClient {

  @GetMapping
  OpenWeatherMap search(@RequestParam(name = "q") String query,
                        @RequestParam(name = "units") String units);

  @GetMapping
  OpenWeatherMap findByCoordinates(@RequestParam(name = "lat") Double latitude,
                                   @RequestParam(name = "lon") Double longitude,
                                   @RequestParam(name = "units") String units);
}

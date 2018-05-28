package br.com.jicecold.ifood.architecture.provider;

import br.com.jicecold.ifood.architecture.provider.model.openwheathermap.OpenWeatherMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OpenWeatherMapProvider {

  public static final String URL_API_OPENWEATHERMAP = "http://api.openweathermap.org/data/2.5/weather";

  @Autowired
  private RestTemplate restTemplate;

  public OpenWeatherMap getWeatherByCityName(String name) {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("q", name);
    return executeGetRequest(params);
  }

  public OpenWeatherMap getWeatherByCoordinates(String latitude, String longitude) {
    MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
    params.add("lat", latitude);
    params.add("lon", longitude);
    return executeGetRequest(params);
  }

  private OpenWeatherMap executeGetRequest(MultiValueMap<String, String> params){
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL_API_OPENWEATHERMAP);
    builder.queryParams(params);
    builder.queryParam("units", "metric");
    builder.queryParam("APPID", "3445a9ae08df1a3117ae58bdfa7cda3d");
    return restTemplate.getForObject(builder.buildAndExpand().toUri(), OpenWeatherMap.class);
  }

}

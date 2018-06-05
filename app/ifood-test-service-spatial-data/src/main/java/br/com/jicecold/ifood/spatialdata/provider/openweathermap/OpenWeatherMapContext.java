package br.com.jicecold.ifood.spatialdata.provider.openweathermap;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Getter
@Component
@Scope(SCOPE_SINGLETON)
public class OpenWeatherMapContext {

  private final String units;

  public OpenWeatherMapContext(@Value("${openweathermap.api.units}") String units) {
    this.units = units;
  }
}

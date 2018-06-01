package br.com.jicecold.ifood.music.core.strategy;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class WeatherMusicConfig {

  private List<WeatherMusicStrategy> strategies;

  public WeatherMusicConfig(List<WeatherMusicStrategy> strategies) {
    this.strategies = strategies;
  }

  public static Builder builder(){
    return new Builder();
  }

  public String getMusicGenreByTemperature(Double temp) {
    Optional<WeatherMusicStrategy> strategyOptional = this.strategies.stream()
        .filter(s -> temp > s.min() && temp <= s.max())
        .findFirst();
    return strategyOptional.isPresent()
        ? strategyOptional.get().genre()
        : "";
  }

  public static class Builder {

    private List<WeatherMusicStrategy> strategies;

    Builder(){
      this.strategies = new ArrayList<>(1);
    }

    public Builder add(WeatherMusicStrategy strategy){
      this.strategies.add(strategy);
      return this;
    }

    public WeatherMusicConfig build() {
      return new WeatherMusicConfig(strategies);
    }
  }
}



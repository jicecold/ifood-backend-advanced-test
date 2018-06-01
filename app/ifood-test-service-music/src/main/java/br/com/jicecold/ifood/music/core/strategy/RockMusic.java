package br.com.jicecold.ifood.music.core.strategy;

public class RockMusic implements WeatherMusicStrategy {
  @Override
  public String genre() {
    return "rock";
  }

  @Override
  public Double min() {
    return 10.0;
  }

  @Override
  public Double max() {
    return 15.0;
  }
}

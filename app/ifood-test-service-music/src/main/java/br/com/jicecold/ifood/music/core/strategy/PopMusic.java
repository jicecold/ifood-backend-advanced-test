package br.com.jicecold.ifood.music.core.strategy;

public class PopMusic implements WeatherMusicStrategy {
  @Override
  public String genre() {
    return "pop";
  }

  @Override
  public Double min() {
    return 15.0;
  }

  @Override
  public Double max() {
    return 30.0;
  }
}

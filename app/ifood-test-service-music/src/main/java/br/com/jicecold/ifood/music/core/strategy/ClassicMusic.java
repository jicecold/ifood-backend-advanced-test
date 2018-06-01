package br.com.jicecold.ifood.music.core.strategy;

public class ClassicMusic implements WeatherMusicStrategy {

  @Override
  public String genre() {
    return "classical";
  }

  @Override
  public Double min() {
    return -100.0;
  }

  @Override
  public Double max() {
    return 10.0;
  }
}

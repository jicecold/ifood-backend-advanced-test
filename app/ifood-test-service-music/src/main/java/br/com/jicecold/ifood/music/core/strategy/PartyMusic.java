package br.com.jicecold.ifood.music.core.strategy;

public class PartyMusic implements WeatherMusicStrategy {
  @Override
  public String genre() {
    return "party";
  }

  @Override
  public Double min() {
    return 30.0;
  }

  @Override
  public Double max() {
    return 100.0;
  }
}

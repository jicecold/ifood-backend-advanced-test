package br.com.jicecold.ifood.music.weather.model;

public class PartyMusic implements GenreMusic {

  public static final String GENRE = "party";
  private Double min;
  private Double max;

  public PartyMusic(Double min, Double max){
    this.min = min;
    this.max = max;
  }

  @Override
  public String genre() {
    return GENRE;
  }

  @Override
  public Double min() {
    return this.min;
  }

  @Override
  public Double max() {
    return this.max;
  }
}

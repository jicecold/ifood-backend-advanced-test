package br.com.jicecold.ifood.music.weather.model;

public class ClassicMusic implements GenreMusic {

  public static final String GENRE = "classical";
  private Double min;
  private Double max;

  public ClassicMusic(Double min, Double max){
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

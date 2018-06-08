package br.com.jicecold.ifood.music.weather.model;

public class PartyMusic implements GenreMusic {

  // Quando o genero musical é Party o spotify não retorna resultados, então optei por electro para este caso
  public static final String GENRE = "electro";
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

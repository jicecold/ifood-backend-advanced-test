package br.com.jicecold.ifood.music.weather.aggregator;

import br.com.jicecold.ifood.music.weather.model.ClassicMusic;
import br.com.jicecold.ifood.music.weather.model.GenreMusic;

import java.util.ArrayList;
import java.util.List;

public class WeatherMusicContext {

  private final List<GenreMusic> genres;

  public WeatherMusicContext(List<GenreMusic> genres) {
    this.genres = genres;
  }

  public static Builder builder() {
    return new Builder();
  }

  public String getMusicGenreByTemperature(Double temp) {
    return this.genres.stream()
        .filter(s -> temp > s.min() && temp <= s.max())
        .map(GenreMusic::genre)
        .findAny()
        .orElse(ClassicMusic.GENRE);
  }

  public static class Builder {

    private List<GenreMusic> genres;

    Builder() {
      this.genres = new ArrayList<>(1);
    }

    public Builder add(GenreMusic strategy) {
      this.genres.add(strategy);
      return this;
    }

    public WeatherMusicContext build() {
      return new WeatherMusicContext(genres);
    }
  }
}



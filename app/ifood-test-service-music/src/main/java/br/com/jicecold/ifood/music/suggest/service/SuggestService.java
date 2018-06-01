package br.com.jicecold.ifood.music.suggest.service;

import br.com.jicecold.ifood.music.suggest.aggregator.MusicWeatherAggregator;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.suggest.model.SongsWeather;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SuggestService {

  @Autowired
  private MusicWeatherAggregator musicWeatherAggregator;

  public SongsWeather suggestByLocation(LocationRequestFilter filter) {
    SongsWeather songsWeather = musicWeatherAggregator.suggestByLocation(filter);
    return songsWeather;
  }
}

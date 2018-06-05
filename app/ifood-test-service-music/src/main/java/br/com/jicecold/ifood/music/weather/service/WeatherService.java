package br.com.jicecold.ifood.music.weather.service;

import br.com.jicecold.ifood.music.weather.aggregator.WeatherMusicAggregator;
import br.com.jicecold.ifood.music.weather.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.weather.model.WeatherTracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

  private final WeatherMusicAggregator weatherMusicAggregator;

  @Autowired
  public WeatherService(WeatherMusicAggregator weatherMusicAggregator) {
    this.weatherMusicAggregator = weatherMusicAggregator;
  }

  public WeatherTracks suggestMusicByLocation(LocationRequestFilter filter) {
    return weatherMusicAggregator.suggestMusicByLocation(filter);
  }
}

package br.com.jicecold.ifood.music.suggest.aggregator;

import br.com.jicecold.ifood.music.core.converter.SearchToTrackConverter;
import br.com.jicecold.ifood.music.core.provider.spatialdata.SpatialDataProvider;
import br.com.jicecold.ifood.music.core.provider.spatialdata.model.Weather;
import br.com.jicecold.ifood.music.core.provider.spotify.SpotifyProvider;
import br.com.jicecold.ifood.music.core.provider.spotify.model.Search;
import br.com.jicecold.ifood.music.core.strategy.ClassicMusic;
import br.com.jicecold.ifood.music.core.strategy.PartyMusic;
import br.com.jicecold.ifood.music.core.strategy.PopMusic;
import br.com.jicecold.ifood.music.core.strategy.RockMusic;
import br.com.jicecold.ifood.music.core.strategy.WeatherMusicConfig;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.suggest.model.SongsWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MusicWeatherAggregator {

  private final WeatherMusicConfig weatherMusicConfig;
  @Autowired
  private SpatialDataProvider spatialDataProvider;
  @Autowired
  private SpotifyProvider spotifyProvider;
  @Autowired
  private SearchToTrackConverter searchToTrackConverter;

  public MusicWeatherAggregator(){
    this.weatherMusicConfig = WeatherMusicConfig.builder()
        .add(new ClassicMusic())
        .add(new PartyMusic())
        .add(new PopMusic())
        .add(new RockMusic())
        .build();
  }

  public SongsWeather suggestByLocation(LocationRequestFilter filter) {

    Weather weather = getWeather(filter);

    String genre = weatherMusicConfig.getMusicGenreByTemperature(weather.getTemp());

    Search search = spotifyProvider.searchTracksByMusicalGenre(genre, filter);

    return SongsWeather.builder()
        .songs(searchToTrackConverter.createFromList(search.getTracks().getItems()))
        .genre(genre)
        .temp(weather.getTemp())
        .longitude(weather.getLongitude())
        .latitude(weather.getLatitude())
        .city(weather.getCityName())
        .build();
  }

  private Weather getWeather(LocationRequestFilter filter) {
    if(Objects.nonNull(filter.getLatitude()) && Objects.nonNull(filter.getLongitude())){
      return spatialDataProvider.getWeatherByCoodinates(filter.getLatitude(), filter.getLongitude());
    }else{
      return spatialDataProvider.getWeatherByCityName(filter.getCity());
    }
  }
}

package br.com.jicecold.ifood.music.core.aggregator;

import br.com.jicecold.ifood.architecture.provider.SpotifyProvider;
import br.com.jicecold.ifood.architecture.provider.model.spotify.AccessToken;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Search;
import br.com.jicecold.ifood.music.core.converter.SearchToTrackConverter;
import br.com.jicecold.ifood.music.core.provider.spatialdata.SpatialDataProvider;
import br.com.jicecold.ifood.music.core.provider.spatialdata.model.Weather;
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

  private final WeatherMusicConfig weatherMusicConfig = WeatherMusicConfig.builder()
                                                            .add(new ClassicMusic())
                                                            .add(new PartyMusic())
                                                            .add(new PopMusic())
                                                            .add(new RockMusic())
                                                            .build();
  @Autowired
  private SpatialDataProvider spatialDataProvider;

  @Autowired
  private SpotifyProvider spotifyProvider;

  @Autowired
  private SearchToTrackConverter searchToTrackConverter;

  public SongsWeather suggestByLocation(LocationRequestFilter filter) {

    Weather weather;
    if(Objects.nonNull(filter.getLatitude()) && Objects.nonNull(filter.getLongitude())){
      weather = spatialDataProvider.getWeatherByCoodinates(filter.getLatitude(), filter.getLongitude());
    }else{
      weather = spatialDataProvider.getWeatherByCityName(filter.getCity());
    }

    String genre = weatherMusicConfig.getMusicGenreByTemperature(weather.getTemp());

    AccessToken accessToken = spotifyProvider.requestAccessToken();
    Search search = spotifyProvider.searchTracksByType(genre, accessToken);

    return SongsWeather.builder()
        .songs(searchToTrackConverter.createFromList(search.getTracks().getItems()))
        .genre(genre)
        .temp(weather.getTemp())
        .longitude(weather.getLongitude())
        .latitude(weather.getLatitude())
        .city(weather.getCityName())
        .build();
  }
}

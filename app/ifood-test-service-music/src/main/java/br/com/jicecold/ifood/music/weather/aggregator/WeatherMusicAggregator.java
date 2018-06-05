package br.com.jicecold.ifood.music.weather.aggregator;

import br.com.jicecold.ifood.music.converter.ItemToStringConverter;
import br.com.jicecold.ifood.music.provider.spatialdata.SpatialDataProvider;
import br.com.jicecold.ifood.music.provider.spatialdata.model.Weather;
import br.com.jicecold.ifood.music.provider.spotify.SpotifyProvider;
import br.com.jicecold.ifood.music.provider.spotify.model.Search;
import br.com.jicecold.ifood.music.weather.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.weather.model.WeatherTracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WeatherMusicAggregator {

  private final WeatherMusicContext weatherMusicContext;
  private final SpatialDataProvider spatialDataProvider;
  private final SpotifyProvider spotifyProvider;
  private final ItemToStringConverter itemToStringConverter;

  @Autowired
  public WeatherMusicAggregator(SpatialDataProvider spatialDataProvider,
                                SpotifyProvider spotifyProvider,
                                ItemToStringConverter itemToStringConverter,
                                WeatherMusicContext weatherMusicContext) {
    this.spatialDataProvider = spatialDataProvider;
    this.spotifyProvider = spotifyProvider;
    this.itemToStringConverter = itemToStringConverter;
    this.weatherMusicContext = weatherMusicContext;
  }

  public WeatherTracks suggestMusicByLocation(LocationRequestFilter filter) {
    final Weather weather = getWeather(filter);
    final String genre = weatherMusicContext.getMusicGenreByTemperature(weather.getTemp());
    final Search search = spotifyProvider.searchTracksByMusicalGenre(genre, filter.getLimit(), filter.getOffset());
    return WeatherTracks.builder()
        .songs(itemToStringConverter.createFromList(search.getTracks().getItems()))
        .genre(genre)
        .temp(weather.getTemp())
        .longitude(weather.getLongitude())
        .latitude(weather.getLatitude())
        .city(weather.getCityName())
        .country(weather.getCountry())
        .build();
  }

  private Weather getWeather(LocationRequestFilter filter) {
    if (Objects.nonNull(filter.getLatitude()) && Objects.nonNull(filter.getLongitude())) {
      return spatialDataProvider.getWeatherByCoodinates(filter.getLatitude(), filter.getLongitude());
    } else {
      return spatialDataProvider.getWeatherByCityName(filter.getCity());
    }
  }
}

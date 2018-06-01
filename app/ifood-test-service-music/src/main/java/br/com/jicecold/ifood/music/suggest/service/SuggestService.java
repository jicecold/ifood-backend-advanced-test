package br.com.jicecold.ifood.music.suggest.service;

import br.com.jicecold.ifood.commons.music.model.TrackResponseModel;
import br.com.jicecold.ifood.music.core.provider.spatialdata.SpatialDataProvider;
import br.com.jicecold.ifood.music.core.provider.spatialdata.model.Weather;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestParamsFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SuggestService {

  //@Autowired
  //private SpotifyProvider spotifyProvider;

  @Autowired
  private SpatialDataProvider spatialDataProvider;

  public TrackResponseModel suggestByLocation(LocationRequestParamsFilter filter) {
//    AccessToken accessToken = spotifyProvider.requestAccessToken();
//    Search search = spotifyProvider.searchTracksByType("rock", accessToken);
//    return new SearchToTrackConverter().convertFrom(search);

    Weather weather = spatialDataProvider.getWeatherByCityName(filter.getCity());

    return TrackResponseModel.builder().build();
  }
}

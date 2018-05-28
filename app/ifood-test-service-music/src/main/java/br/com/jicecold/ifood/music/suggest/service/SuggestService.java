package br.com.jicecold.ifood.music.suggest.service;

import br.com.jicecold.ifood.architecture.provider.SpotifyProvider;
import br.com.jicecold.ifood.architecture.provider.model.spotify.AccessToken;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Search;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestParamsFilter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Log4j2
@Service
public class SuggestService {

  private static List<String> MOCK_MUSICS = Arrays.asList("Musica 1", "Musica 2", "Musica 3", "Musica 4", "Musica 5");

  @Autowired
  private SpotifyProvider spotifyProvider;

  public List<String> suggestByLocation(LocationRequestParamsFilter filter) {

    AccessToken accessToken = spotifyProvider.requestAccessToken();
    Search search = spotifyProvider.searchTracksByType("rock", accessToken);
    log.info(search);

    if(StringUtils.isNotBlank(filter.getCity())){
      return MOCK_MUSICS;
    }

    return MOCK_MUSICS;
  }
}

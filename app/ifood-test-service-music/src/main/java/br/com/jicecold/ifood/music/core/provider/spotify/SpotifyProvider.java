package br.com.jicecold.ifood.music.core.provider.spotify;

import br.com.jicecold.ifood.architecture.generic.model.RequestFilter;
import br.com.jicecold.ifood.music.core.provider.spotify.client.SpotifyAccountFeignClient;
import br.com.jicecold.ifood.music.core.provider.spotify.client.SpotifyApiFeignClient;
import br.com.jicecold.ifood.music.core.provider.spotify.model.AccessToken;
import br.com.jicecold.ifood.music.core.provider.spotify.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SpotifyProvider {

  @Autowired
  private SpotifyAccountFeignClient spotifyAccountFeignClient;

  @Autowired
  private SpotifyApiFeignClient spotifyApiFeignClient;

  @Autowired
  private SpotifyDataGuard spotifyDataGuard;

  @PostConstruct
  public void init() {
    final String grantType = String.format("%s=%s", SpotifyDataGuard.GRANT_TYPE,
        spotifyDataGuard.getAccountGrantType());
    final AccessToken token = spotifyAccountFeignClient.requestToken(grantType);
    spotifyDataGuard.setToken(token);
  }

  public Search searchTracksByMusicalGenre(String genre, RequestFilter filter){
    final String searchType = spotifyDataGuard.getSearchType();
    final Integer limit = spotifyDataGuard.getOrDefaultSearchLimit(filter.getLimit());
    final Integer offset = spotifyDataGuard.getOrDefaultSearchOffset(filter.getOffset());
    return spotifyApiFeignClient.search(genre, searchType, limit, offset);
  }

}

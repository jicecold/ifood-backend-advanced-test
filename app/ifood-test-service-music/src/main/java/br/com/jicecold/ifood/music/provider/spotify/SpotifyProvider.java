package br.com.jicecold.ifood.music.provider.spotify;

import br.com.jicecold.ifood.music.provider.spotify.client.SpotifyAccountFeignClient;
import br.com.jicecold.ifood.music.provider.spotify.client.SpotifyApiFeignClient;
import br.com.jicecold.ifood.music.provider.spotify.model.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class SpotifyProvider {

  private final SpotifyAccountFeignClient spotifyAccountFeignClient;
  private final SpotifyApiFeignClient spotifyApiFeignClient;
  private final SpotifyContext spotifyContext;

  @Autowired
  public SpotifyProvider(SpotifyAccountFeignClient spotifyAccountFeignClient,
                         SpotifyApiFeignClient spotifyApiFeignClient,
                         SpotifyContext spotifyContext) {
    this.spotifyAccountFeignClient = spotifyAccountFeignClient;
    this.spotifyApiFeignClient = spotifyApiFeignClient;
    this.spotifyContext = spotifyContext;
  }

  private void requestAccessToken() {
    spotifyContext.setToken(spotifyAccountFeignClient
        .requestToken(format("grant_type=%s", spotifyContext.getAccountGrantType())));
  }

  public Search searchTracksByMusicalGenre(String genre, Integer limit, Integer offset) {

    if (!spotifyContext.verifyIfAccessTokenIsValid())
      requestAccessToken();

    return spotifyApiFeignClient.search(format("genre:%s", genre),
        spotifyContext.getSearchType(),
        spotifyContext.getOrDefaultSearchLimit(limit),
        spotifyContext.getOrDefaultSearchOffset(offset));
  }

}

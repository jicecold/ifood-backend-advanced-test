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
  private final SpotifyDataGuard spotifyDataGuard;

  @Autowired
  public SpotifyProvider(SpotifyAccountFeignClient spotifyAccountFeignClient,
                         SpotifyApiFeignClient spotifyApiFeignClient,
                         SpotifyDataGuard spotifyDataGuard) {
    this.spotifyAccountFeignClient = spotifyAccountFeignClient;
    this.spotifyApiFeignClient = spotifyApiFeignClient;
    this.spotifyDataGuard = spotifyDataGuard;
  }

  private void requestAccessToken() {
    spotifyDataGuard.setToken(spotifyAccountFeignClient
        .requestToken(format("grant_type=%s", spotifyDataGuard.getAccountGrantType())));
  }

  public Search searchTracksByMusicalGenre(String genre, Integer limit, Integer offset) {

    if (!spotifyDataGuard.verifyAccessTokenIsValid())
      requestAccessToken();

    return spotifyApiFeignClient.search(format("genre:%s", genre),
        spotifyDataGuard.getSearchType(),
        spotifyDataGuard.getOrDefaultSearchLimit(limit),
        spotifyDataGuard.getOrDefaultSearchOffset(offset));
  }

}

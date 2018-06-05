package br.com.jicecold.ifood.music.provider.spotify.fallback;

import br.com.jicecold.ifood.music.provider.spotify.SpotifyContext;
import br.com.jicecold.ifood.music.provider.spotify.client.SpotifyAccountFeignClient;
import br.com.jicecold.ifood.music.provider.spotify.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpotifyAccountFeignFallback implements SpotifyAccountFeignClient {

  private final SpotifyContext spotifyContext;

  @Autowired
  public SpotifyAccountFeignFallback(SpotifyContext spotifyContext) {
    this.spotifyContext = spotifyContext;
  }

  @Override
  public AccessToken requestToken(String grantType) {
    log.error("FALLBACK:[SpotifyAccountFeignClient]: Retornando ultimo token...");
    return spotifyContext.getToken();
  }
}

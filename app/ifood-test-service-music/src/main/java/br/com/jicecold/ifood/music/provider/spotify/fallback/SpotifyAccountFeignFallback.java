package br.com.jicecold.ifood.music.provider.spotify.fallback;

import br.com.jicecold.ifood.music.provider.spotify.SpotifyDataGuard;
import br.com.jicecold.ifood.music.provider.spotify.client.SpotifyAccountFeignClient;
import br.com.jicecold.ifood.music.provider.spotify.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SpotifyAccountFeignFallback implements SpotifyAccountFeignClient {

  private final SpotifyDataGuard spotifyDataGuard;

  @Autowired
  public SpotifyAccountFeignFallback(SpotifyDataGuard spotifyDataGuard) {
    this.spotifyDataGuard = spotifyDataGuard;
  }

  @Override
  public AccessToken requestToken(String grantType) {
    log.error("FALLBACK:[SpotifyAccountFeignClient]: Retornando ultimo token...");
    return spotifyDataGuard.getToken();
  }
}

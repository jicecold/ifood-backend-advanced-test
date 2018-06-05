package br.com.jicecold.ifood.music.provider.spotify.config;

import br.com.jicecold.ifood.music.provider.spotify.SpotifyDataGuard;
import br.com.jicecold.ifood.music.provider.spotify.interceptor.SpotifyApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SpotifyApiFeignConfig {

  private final SpotifyDataGuard spotifyDataGuard;

  @Autowired
  public SpotifyApiFeignConfig(SpotifyDataGuard spotifyDataGuard) {
    this.spotifyDataGuard = spotifyDataGuard;
  }

  @Bean
  public SpotifyApiInterceptor spotifyAccountInterceptor() {
    return new SpotifyApiInterceptor(spotifyDataGuard);
  }
}

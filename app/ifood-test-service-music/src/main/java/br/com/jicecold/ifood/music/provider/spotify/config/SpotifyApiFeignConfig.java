package br.com.jicecold.ifood.music.provider.spotify.config;

import br.com.jicecold.ifood.music.provider.spotify.SpotifyContext;
import br.com.jicecold.ifood.music.provider.spotify.interceptor.SpotifyApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class SpotifyApiFeignConfig {

  private final SpotifyContext spotifyContext;

  @Autowired
  public SpotifyApiFeignConfig(SpotifyContext spotifyContext) {
    this.spotifyContext = spotifyContext;
  }

  @Bean
  public SpotifyApiInterceptor spotifyAccountInterceptor() {
    return new SpotifyApiInterceptor(spotifyContext);
  }
}

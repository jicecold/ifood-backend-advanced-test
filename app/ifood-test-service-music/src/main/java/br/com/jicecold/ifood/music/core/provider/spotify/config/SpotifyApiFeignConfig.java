package br.com.jicecold.ifood.music.core.provider.spotify.config;

import br.com.jicecold.ifood.music.core.provider.spotify.SpotifyDataGuard;
import br.com.jicecold.ifood.music.core.provider.spotify.interceptor.SpotifyApiInterceptor;
import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyApiFeignConfig {

  private SpotifyDataGuard spotifyDataGuard;

  @Autowired
  public SpotifyApiFeignConfig(SpotifyDataGuard spotifyDataGuard) {
    this.spotifyDataGuard = spotifyDataGuard;
  }

  @Bean
  public Feign.Builder builder() {
    return new Feign.Builder()
        .logLevel(Logger.Level.FULL)
        .requestInterceptor(new SpotifyApiInterceptor(spotifyDataGuard));
  }

}

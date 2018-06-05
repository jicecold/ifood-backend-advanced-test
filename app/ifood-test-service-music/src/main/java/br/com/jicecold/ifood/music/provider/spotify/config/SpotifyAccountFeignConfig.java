package br.com.jicecold.ifood.music.provider.spotify.config;

import br.com.jicecold.ifood.music.provider.spotify.interceptor.SpotifyAccountInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class SpotifyAccountFeignConfig {

  private final String clientId;
  private final String clientSecret;

  public SpotifyAccountFeignConfig(@Value("${spotify.security.id}") String clientId,
                                   @Value("${spotify.security.secret}") String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @Bean
  public SpotifyAccountInterceptor spotifyAccountInterceptor() {
    return new SpotifyAccountInterceptor(clientId, clientSecret);
  }
}

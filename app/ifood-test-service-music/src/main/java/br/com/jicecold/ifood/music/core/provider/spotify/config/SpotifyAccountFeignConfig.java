package br.com.jicecold.ifood.music.core.provider.spotify.config;

import br.com.jicecold.ifood.music.core.provider.spotify.interceptor.SpotifyAccountInterceptor;
import feign.Feign;
import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyAccountFeignConfig {

  private final String clientId;
  private final String clientSecret;

  public SpotifyAccountFeignConfig(@Value("${spotify.security.id}") String clientId,
                                   @Value("${spotify.security.secret}") String clientSecret){
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @Bean
  public Feign.Builder builder() {
    return new Feign.Builder()
        .logLevel(Logger.Level.FULL)
        .requestInterceptor(new SpotifyAccountInterceptor(clientId, clientSecret));
  }
}

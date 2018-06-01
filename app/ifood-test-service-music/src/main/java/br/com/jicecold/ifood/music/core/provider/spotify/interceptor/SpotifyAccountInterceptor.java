package br.com.jicecold.ifood.music.core.provider.spotify.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;

import static java.lang.String.format;
import static org.springframework.util.Base64Utils.encode;

public class SpotifyAccountInterceptor implements RequestInterceptor {

  private final String clientId;
  private final String clientSecret;

  public SpotifyAccountInterceptor(String clientId, String clientSecret) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @Override
  public void apply(RequestTemplate template) {
    template.header(HttpHeaders.AUTHORIZATION, createBasicAuthorizationToken());
  }

  private String createBasicAuthorizationToken() {
    final String formatted = format("%s:%s", this.clientId, this.clientSecret);
    final byte[] encoded = encode(formatted.getBytes());
    return format("Basic %s", new String(encoded));
  }
}

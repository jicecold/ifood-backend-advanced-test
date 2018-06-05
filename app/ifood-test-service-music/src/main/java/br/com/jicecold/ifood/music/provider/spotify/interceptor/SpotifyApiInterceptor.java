package br.com.jicecold.ifood.music.provider.spotify.interceptor;

import br.com.jicecold.ifood.music.provider.spotify.SpotifyDataGuard;
import br.com.jicecold.ifood.music.provider.spotify.model.AccessToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;


public class SpotifyApiInterceptor implements RequestInterceptor {

  private final SpotifyDataGuard spotifyDataGuard;

  public SpotifyApiInterceptor(SpotifyDataGuard spotifyDataGuard) {
    this.spotifyDataGuard = spotifyDataGuard;
  }

  @Override
  public void apply(RequestTemplate template) {
    template.header(HttpHeaders.AUTHORIZATION, getSpotifyTokenAuthorization());
  }

  private String getSpotifyTokenAuthorization() {
    AccessToken accessToken = spotifyDataGuard.getToken();
    final String tokenType = accessToken.getTokenType();
    final String token = accessToken.getAccessToken();
    return String.format("%s %s", tokenType, token);
  }
}

package br.com.jicecold.ifood.music.provider.spotify.client;

import br.com.jicecold.ifood.music.provider.spotify.config.SpotifyAccountFeignConfig;
import br.com.jicecold.ifood.music.provider.spotify.fallback.SpotifyAccountFeignFallback;
import br.com.jicecold.ifood.music.provider.spotify.model.AccessToken;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${spotify.account.name}", url = "${spotify.account.url}",
    configuration = SpotifyAccountFeignConfig.class,
    fallback = SpotifyAccountFeignFallback.class)
public interface SpotifyAccountFeignClient {

  @PostMapping(value = "${spotify.account.token.path}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  AccessToken requestToken(@RequestBody String grantType);

}

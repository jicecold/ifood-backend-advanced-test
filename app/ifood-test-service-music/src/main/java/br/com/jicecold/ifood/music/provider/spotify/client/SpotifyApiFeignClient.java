package br.com.jicecold.ifood.music.provider.spotify.client;

import br.com.jicecold.ifood.music.provider.spotify.config.SpotifyApiFeignConfig;
import br.com.jicecold.ifood.music.provider.spotify.fallback.SpotifyApiFeignFallback;
import br.com.jicecold.ifood.music.provider.spotify.model.Search;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${spotify.api.name}", url = "${spotify.api.url}",
    configuration = SpotifyApiFeignConfig.class,
    fallback = SpotifyApiFeignFallback.class)
public interface SpotifyApiFeignClient {

  @GetMapping(value = "${spotify.api.search.path}")
  Search search(@RequestParam("q") String query,
                @RequestParam("type") String type,
                @RequestParam("limit") Integer limit,
                @RequestParam("offset") Integer offset);

}

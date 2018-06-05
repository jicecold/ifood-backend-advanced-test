package br.com.jicecold.ifood.music.provider.spotify.fallback;

import br.com.jicecold.ifood.music.provider.spotify.client.SpotifyApiFeignClient;
import br.com.jicecold.ifood.music.provider.spotify.model.Item;
import br.com.jicecold.ifood.music.provider.spotify.model.Search;
import br.com.jicecold.ifood.music.provider.spotify.model.Tracks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Slf4j
@Component
public class SpotifyApiFeignFallback implements SpotifyApiFeignClient {

  @Override
  public Search search(String query, String type, Integer limit, Integer offset) {
    log.error("FALLBACK:[SpotifyApiFeignClient]: Retornando resultado do ultimo request...");
    return Search.builder()
        .tracks(createDefaultTracks())
        .build();
  }

  private Tracks createDefaultTracks() {
    return Tracks.builder()
        .items(Collections
            .singletonList(Item.builder()
                .build()))
        .build();
  }
}

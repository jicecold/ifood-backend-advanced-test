package br.com.jicecold.ifood.music.core.provider.spotify.model;

import br.com.jicecold.ifood.architecture.generic.model.RequestFilter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotifySearchApiFilter extends RequestFilter {
  String query;
  String type;
}

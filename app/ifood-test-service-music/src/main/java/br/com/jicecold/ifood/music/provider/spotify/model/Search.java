package br.com.jicecold.ifood.music.provider.spotify.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Search {
  private Tracks tracks;
}

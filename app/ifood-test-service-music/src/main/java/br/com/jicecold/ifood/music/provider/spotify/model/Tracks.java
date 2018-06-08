package br.com.jicecold.ifood.music.provider.spotify.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tracks {
  @JsonProperty("items")
  private List<Item> items = null;
}

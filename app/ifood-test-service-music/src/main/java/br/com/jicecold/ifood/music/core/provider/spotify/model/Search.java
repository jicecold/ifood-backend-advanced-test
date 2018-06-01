
package br.com.jicecold.ifood.music.core.provider.spotify.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Search {
  @JsonProperty("tracks")
  private Tracks tracks;
}

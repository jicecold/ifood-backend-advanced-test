
package br.com.jicecold.ifood.music.core.provider.spotify.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
  @JsonProperty("available_markets")
  private List<String> availableMarkets = null;
  @JsonProperty("disc_number")
  private Integer discNumber;
  @JsonProperty("duration_ms")
  private Integer durationMs;
  @JsonProperty("explicit")
  private Boolean explicit;
  @JsonProperty("href")
  private String href;
  @JsonProperty("id")
  private String id;
  @JsonProperty("is_local")
  private Boolean isLocal;
  @JsonProperty("name")
  private String name;
  @JsonProperty("popularity")
  private Integer popularity;
  @JsonProperty("preview_url")
  private String previewUrl;
  @JsonProperty("track_number")
  private Integer trackNumber;
  @JsonProperty("type")
  private String type;
  @JsonProperty("uri")
  private String uri;
}


package br.com.jicecold.ifood.architecture.provider.model.spotify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class  Tracks {
  @JsonProperty("items")
  private List<Item> items = null;
  @JsonProperty("limit")
  private Integer limit;
  @JsonProperty("next")
  private String next;
  @JsonProperty("offset")
  private Integer offset;
  @JsonProperty("previous")
  private Object previous;
  @JsonProperty("total")
  private Integer total;
}

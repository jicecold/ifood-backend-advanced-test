package br.com.jicecold.ifood.commons.music.model;

import br.com.jicecold.ifood.commons.generic.model.ResponseModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TrackResponseModel extends ResponseModel<List<String>> {

  private List<String> data;

  @Override
  public List<String> getData() {
    return this.data;
  }

  @Override
  public void setData(List<String> data) {
    this.data = data;
  }
}

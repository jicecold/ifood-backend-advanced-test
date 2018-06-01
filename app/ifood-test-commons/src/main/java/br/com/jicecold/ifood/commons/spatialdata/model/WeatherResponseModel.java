package br.com.jicecold.ifood.commons.spatialdata.model;

import br.com.jicecold.ifood.commons.generic.model.ResponseModel;
import lombok.Data;

@Data
public class WeatherResponseModel<T> extends ResponseModel<T> {

  private T data;

  @Override
  public T getData() {
    return this.data;
  }

  @Override
  public void setData(T data) {
    this.data = data;
  }
}

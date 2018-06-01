package br.com.jicecold.ifood.commons.generic.model;

public abstract class ResponseModel<T> {
  public abstract T getData();
  public abstract void setData(T data);
}

package br.com.jicecold.ifood.architecture.generic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFilter {
  Integer limit;
  Integer offset;
}

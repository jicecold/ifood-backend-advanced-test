package br.com.jicecold.ifood.music.suggest.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestParamsFilter;
import br.com.jicecold.ifood.music.suggest.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("suggest")
public class SuggestController extends BaseController {

  @Autowired
  private SuggestService suggestService;

  @GetMapping("location")
  public List<String> suggestByLocation(LocationRequestParamsFilter filter) {
    return suggestService.suggestByLocation(filter);
  }

}

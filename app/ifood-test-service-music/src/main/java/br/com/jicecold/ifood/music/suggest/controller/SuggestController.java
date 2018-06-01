package br.com.jicecold.ifood.music.suggest.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.commons.music.model.TrackResponseModel;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestParamsFilter;
import br.com.jicecold.ifood.music.suggest.service.SuggestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("suggest")
public class SuggestController extends BaseController {

  @Autowired
  private SuggestService suggestService;

  @GetMapping("by-weather-location")
  public TrackResponseModel suggestByLocation(LocationRequestParamsFilter filter) {
    return suggestService.suggestByLocation(filter);
  }

}

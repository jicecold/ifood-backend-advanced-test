package br.com.jicecold.ifood.music.suggest.controller;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import br.com.jicecold.ifood.architecture.generic.model.ResponseModel;
import br.com.jicecold.ifood.music.suggest.model.LocationRequestFilter;
import br.com.jicecold.ifood.music.suggest.model.SongsWeather;
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
  public ResponseModel<SongsWeather> suggestByLocation(LocationRequestFilter filter) {
    SongsWeather data = suggestService.suggestByLocation(filter);
    return ResponseModel.<SongsWeather>builder()
        .content(data)
        .build();
  }

}

package br.com.jicecold.ifood.music.location;

import br.com.jicecold.ifood.architecture.generic.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController extends BaseController {

  private static List<String> MOCK_MUSICS = Arrays.asList("Musica 1", "Musica 2", "Musica 3", "Musica 4", "Musica 5");

  @GetMapping("city")
  public List<String> suggestMusicsByCityName(@RequestParam String name) {
    return MOCK_MUSICS;
  }

  @GetMapping("coordinates")
  public List<String> suggestMusicsByCoordinates(@RequestParam String lat,
                                                 @RequestParam String lon) {
    return MOCK_MUSICS;
  }

}

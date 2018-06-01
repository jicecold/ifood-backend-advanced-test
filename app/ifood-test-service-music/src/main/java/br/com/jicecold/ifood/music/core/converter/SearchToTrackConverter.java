package br.com.jicecold.ifood.music.core.converter;

import br.com.jicecold.ifood.architecture.generic.converter.Converter;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Item;
import org.springframework.stereotype.Component;

@Component
public class SearchToTrackConverter extends Converter<Item, String> {

  public SearchToTrackConverter() {
    super(Item::getName);
  }
}

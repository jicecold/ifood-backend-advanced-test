package br.com.jicecold.ifood.music.converter;


import br.com.jicecold.ifood.architecture.generic.converter.Converter;
import br.com.jicecold.ifood.music.provider.spotify.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemToStringConverter extends Converter<Item, String> {
  public ItemToStringConverter() {
    super(Item::getName);
  }
}

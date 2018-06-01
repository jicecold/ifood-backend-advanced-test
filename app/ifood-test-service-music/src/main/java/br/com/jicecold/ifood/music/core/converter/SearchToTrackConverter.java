package br.com.jicecold.ifood.music.core.converter;

import br.com.jicecold.ifood.architecture.generic.converter.Converter;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Item;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Search;
import br.com.jicecold.ifood.architecture.provider.model.spotify.Tracks;
import br.com.jicecold.ifood.commons.music.model.TrackResponseModel;


import java.util.List;
import java.util.stream.Collectors;

public class SearchToTrackConverter extends Converter<Search, TrackResponseModel> {

  public SearchToTrackConverter() {
    super(source -> {
      Tracks tracks = source.getTracks();
      List<Item> itemList = tracks.getItems();
      List<String> models = itemList
          .stream().map(Item::getName)
          .collect(Collectors.toList());
      return TrackResponseModel.builder()
          .data(models)
          .build();
    });
  }
}

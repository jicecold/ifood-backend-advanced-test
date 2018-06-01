package br.com.jicecold.ifood.architecture.generic.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Converter<SOURCE, TARGET> {

  private final Function<SOURCE, TARGET> source;

  public Converter(final Function<SOURCE, TARGET> source) {
    this.source = source;
  }

  public final TARGET convertFrom(final SOURCE source) {
    return this.source.apply(source);
  }

  public final List<TARGET> createFromList(final Collection<SOURCE> sourceCollection) {
    return sourceCollection.stream().map(this::convertFrom).collect(Collectors.toList());
  }

}

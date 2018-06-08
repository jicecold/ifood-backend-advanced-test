package br.com.jicecold.ifood.music.weather.aggregator;


import br.com.jicecold.ifood.music.weather.model.ClassicMusic;
import br.com.jicecold.ifood.music.weather.model.PartyMusic;
import br.com.jicecold.ifood.music.weather.model.PopMusic;
import br.com.jicecold.ifood.music.weather.model.RockMusic;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class WeatherMusicContextTest {

  private WeatherMusicContext context;

  @Before
  public void setUp() {
    context = WeatherMusicContext.builder()
        .add(new PartyMusic(30.0, 100.0))
        .add(new PopMusic(15.0, 30.0))
        .add(new RockMusic(10.0, 14.0))
        .add(new ClassicMusic(-100.0, 10.0))
        .build();
  }

  @Test
  public void IfTemperatureIsHotThenPartyMusics(){
    log.info("If temperature (celcius) is above 30 degrees, suggest tracks for party");
    String genre = context.getMusicGenreByTemperature(30.1D);
    log.info("Result: {}", genre);
    Assert.assertEquals(PartyMusic.GENRE, genre);
  }

  @Test
  public void IfTemperatureIsAverageThenPopMusics(){
    log.info("In case temperature is between 15 and 30 degrees, suggest pop music tracks");
    String genre = context.getMusicGenreByTemperature(22.4D);
    log.info("Result: {}", genre);
    Assert.assertEquals(PopMusic.GENRE, genre);
  }

  @Test
  public void IfTemperatureIsChillyThenRockMusics(){
    log.info("If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks");
    String genre = context.getMusicGenreByTemperature(13.8);
    log.info("Result: {}", genre);
    Assert.assertEquals(RockMusic.GENRE, genre);
  }

  @Test
  public void OtherwiseAndIfTemperatureIsFreezingThenClassicalMusics(){
    log.info("Otherwise, if it's freezing outside, suggests classical music tracks");
    String genre = context.getMusicGenreByTemperature(14.5);
    log.info("Result: {}", genre);
    Assert.assertEquals(ClassicMusic.GENRE, genre);
  }

}

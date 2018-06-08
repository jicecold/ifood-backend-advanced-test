package br.com.jicecold.ifood.music;

import br.com.jicecold.ifood.architecture.AbstractServiceApplication;
import br.com.jicecold.ifood.music.weather.model.ClassicMusic;
import br.com.jicecold.ifood.music.weather.model.PartyMusic;
import br.com.jicecold.ifood.music.weather.model.PopMusic;
import br.com.jicecold.ifood.music.weather.model.RockMusic;
import br.com.jicecold.ifood.music.weather.aggregator.WeatherMusicContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class MusicServiceApplication extends AbstractServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(MusicServiceApplication.class, args);
  }

  @Bean
  public WeatherMusicContext weatherMusicConfig(){
    return WeatherMusicContext.builder()
        .add(new PartyMusic(30.0, 100.0))
        .add(new PopMusic(15.0, 30.0))
        .add(new RockMusic(10.0, 14.0))
        .add(new ClassicMusic(-100.0, 10.0))
        .build();
  }
}

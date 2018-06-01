package br.com.jicecold.ifood.music;

import br.com.jicecold.ifood.architecture.AbstractServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MusicServiceApplication extends AbstractServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(MusicServiceApplication.class, args);
  }
}

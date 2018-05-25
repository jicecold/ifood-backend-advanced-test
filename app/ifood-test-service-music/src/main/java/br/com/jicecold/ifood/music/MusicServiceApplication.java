package br.com.jicecold.ifood.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MusicServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(MusicServiceApplication.class, args);
  }
}

package br.com.jicecold.ifood.spatialdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"br.com.jicecold.ifood"})
public class SpatialDataServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpatialDataServiceApplication.class, args);
  }
}

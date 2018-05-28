package br.com.jicecold.ifood.spatialdata;

import br.com.jicecold.ifood.architecture.AbstractServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpatialDataServiceApplication extends AbstractServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpatialDataServiceApplication.class, args);
  }
}

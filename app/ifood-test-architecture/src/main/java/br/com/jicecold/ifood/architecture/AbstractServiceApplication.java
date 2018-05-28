package br.com.jicecold.ifood.architecture;


import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@ComponentScan({"br.com.jicecold.ifood"})
public abstract class AbstractServiceApplication {
}

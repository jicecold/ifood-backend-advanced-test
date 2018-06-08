# iFood Backend Advanced Test

Create a micro-service able to accept RESTful requests receiving as parameter either city name or lat long coordinates and returns a playlist (only track names is fine) suggestion according to the current temperature.

## Business rules

* If temperature (celcius) is above 30 degrees, suggest tracks for party
* In case temperature is between 15 and 30 degrees, suggest pop music tracks
* If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
* Otherwise, if it's freezing outside, suggests classical music tracks 

## Hints

You can make usage of OpenWeatherMaps API (https://openweathermap.org) to fetch temperature data and Spotify (https://developer.spotify.com) to suggest the tracks as part of the playlist.

## Non functional requirements

As this service will be a worldwide success, it must be prepared to be fault tolerant, responsive and resilient.

Use whatever language, tools and frameworks you feel comfortable to, and briefly elaborate on your solution, architecture details, choice of patterns and frameworks.

Also, make it easy to deploy/run your service(s) locally (consider using some container/vm solution for this). Once done, share your code with us.
 
# Solução

Para a solução do desafio proposto, foi desenvolvida uma pequena plataforna RESTfull baseada em microserviços, utilizando as seguintes técnologias:

* Java 8;
* Maven 3;
* Spring Framework
   * Spring Boot (2.0.2);
   * Spring Cloud (Finchley.RC1);
* Docker (18.05);

## Estrutura do Projeto

O projeto foi dividido em módulos, conforme o esquema abaixo:


    .
    ├── app                                   
    │   ├── ifood-test-architecture           # Módulo base que define pontos comuns entre os serviços.
    │   ├── ifood-test-cloud-gateway          # Serviço que trabalha como proxy e load balancer.
    │   ├── ifood-test-cloud-registry         # Serviço que trabalha como service discovery.
    │   ├── ifood-test-service-music          # Serviço responsável pela entrega de musicas.
    │   ├── ifood-test-service-spatial-data   # Serviço responsevel por entregadas dados geoespaciais.
    │   ├── docker-compose.yml                # Arquivo que faz a "Orquestração" dos serviços;
    │   ├── Dockerfile                        # Gera uma imagem base para conteineinerização do projeto.
    │   └── pom.xml
    └── README.md

A idéia por trás do solução, foi criar um pequeno ambiente esalável e tolerante a falhas **(com algumas ressalvas para não deixar a solução muito complexa, como a não redundancia do serviços de gateway e registry)**, além de demostrar os conhecimentos técnicos em torno das técnologias citadas. Para tanto, a seguinte arquitetura foi desenvolvida, de acordo com o esquema a seguir:

![alt text](doc/esquema1.png)

### Módulo Gateway
------------------

Como a solução proposta pode apresentar diversas instacias de microserviços rodando em diferentes portas ou contextos, foi feita a opção por implementar um módulo de **Gateway**, que funciona basicamente como meio de entrada e roteamento para um determinado microserviço, respeitando as rotas configuradas no arquivo `application.yml`. Por fim, o objetivo é que todo o trafego entre a `plataforma` e o `client`, passe pelo módulo de Gateway.

Como exeplificado no esquema anterior, o gateway irá receber a requisição e consultar no `Service Discovery`, neste caso o serviço chamado `Registry`, por qual instancia de microserviço registrado, reposnde aquela determinada rota.

Para este exemplo, está sendo utilizado a solução do pacote [Netflix OSS](https://netflix.github.io/) , chamado [Zuul](https://github.com/Netflix/zuul) como implementação do módulo de gateway.

### Módulo Registry (Service Discovery)
---------------------------------------

O `Service Discovery` é um dos principios aplicados em arquiteturas basedas em microserviços, cujo o objetivo é identificar e registrar informações das diferentes instancias de serviços dentro da aquitetura, como por exemplo, quais são os endereços de `hosts` e `porta`, nos quais esses serviços estão respondendo, bem como seu `status`.

Para esta solução, o conceito se aplica devido as multiplas instacias dos serviços de `music` e `spatial-data`, que podem assumir endereços de IP e Porta dinamicamente, o que pode justificar a implementação desse recurso.

Neste caso, o [Eureka](https://github.com/Netflix/eureka), que também faz parte da Stack de soluções da `Netflix OSS`, é utilizado como implementação de `Service Discovery`.

## Referências:
* Eureka - https://github.com/Netflix/eureka
* Netflix OSS - https://netflix.github.io/
* Spring Cloud Netflix - https://cloud.spring.io/spring-cloud-netflix/
* Zuul - https://github.com/Netflix/zuul
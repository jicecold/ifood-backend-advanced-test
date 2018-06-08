FROM jicecold/maven-base-ifood:3.5.2-jdk-8

COPY . /app

WORKDIR /app

EXPOSE 9092

CMD ["mvn", "clean", "spring-boot:run"]
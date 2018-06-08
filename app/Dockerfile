FROM maven:3.5.3-jdk-8-alpine

COPY . /root/src

WORKDIR /root/src

RUN mvn clean install

CMD ["/bin/bash"]
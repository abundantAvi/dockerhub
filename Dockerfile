FROM openjdk:8-jdk-alpine
RUN apk add curl jq


#workspace
WORKDIR /usr/share/myFolder

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD sales.xml sales.xml
ADD purchase.xml purchase.xml
ADD inventory.xml inventory.xml
ADD containers.xml containers.xml
ADD shipment.xml shipment.xml


ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh

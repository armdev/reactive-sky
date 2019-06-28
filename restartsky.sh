#!/usr/bin/env bash

set -e

echo "Restart sky"
sudo docker rm -f sky
sudo docker rmi -f sky
mvn clean install -pl sky -am -DskipTests=true
sudo docker-compose up -d --no-deps --build sky








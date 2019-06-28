#!/usr/bin/env bash

set -e
echo "Build the sky"
mvn clean install -pl sky -am -DskipTests=true





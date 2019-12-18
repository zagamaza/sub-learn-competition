#!/usr/bin/env bash
cd ..
./gradlew clean
docker stop $(docker ps --filter "name=ms-egisso" -q)
docker stop $(docker ps --filter "name=db-egisso" -q)
docker rm $(docker ps --filter "name=ms-egisso" -aq)
docker rm $(docker ps --filter "name=db-egisso" -aq)
docker rmi $(docker images --filter "reference=*ms-egisso*" -q) --force
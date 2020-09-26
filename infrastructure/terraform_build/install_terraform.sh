#!/bin/bash


echo "****************************"
echo "** Downloading terraform Docker Image ***"
echo "****************************"
docker-compose -f docker-compose.yml build --no-cache
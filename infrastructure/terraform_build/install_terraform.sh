#!/bin/bash


echo "****************************"
echo "** Downloading terraform Docker Image ***"
echo "****************************"
docker-compose -f terraform_build/docker-compose.yml build --no-cache
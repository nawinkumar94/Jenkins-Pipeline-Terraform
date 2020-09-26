#!/bin/bash


echo "****************************"
echo "** Downloading terraform Docker Image ***"
echo "****************************"

cd infrastructure && docker-compose -f docker-compose.yml build --no-cache
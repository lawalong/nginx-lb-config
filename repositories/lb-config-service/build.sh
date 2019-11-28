#!/usr/bin/env bash

mvn package

docker build -t lb-config-service:latest .
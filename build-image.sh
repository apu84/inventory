#!/usr/bin/env bash
# This script builds the Docker image for the project.
version=0.0.2
./gradlew bootBuildImage \
  --imageName=apu84/inventory:$version \
  --builder=paketobuildpacks/builder:base \
  -PBP_PLATFORM=linux/amd64
podman --connection podman-machine-default-root push docker.io/apu84/inventory:$version
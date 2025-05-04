#!/usr/bin/env bash
# This script builds the Docker image for the project.
version=0.0.1
./gradlew bootBuildImage --imageName=apu84/inventory:$version
podman --connection podman-machine-default-root push docker.io/apu84/inventory:$version
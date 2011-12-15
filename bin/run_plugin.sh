#!/usr/bin/env bash

mvn package

cp target/spheroids-1.0-SNAPSHOT.jar server/plugins

rm -fr server/world


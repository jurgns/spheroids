#!/usr/bin/env bash

mvn package

cp target/spheroids-1.0-SNAPSHOT.jar server/plugins

rm -fr server/world

if [ ! -a "server/craftbukkit-1.0.1-R2-SNAPSHOT.jar" ]
then
	curl http://ci.bukkit.org/job/dev-CraftBukkit/lastSuccessfulBuild/artifact/target/craftbukkit-1.0.1-R2-SNAPSHOT.jar -o server/craftbukkit-1.0.1-R2-SNAPSHOT.jar 
fi


#!/bin/bash
echo CapitalReporting Continuous Integration
echo Build ID $BUILD_ID
pwd
export JAVA_HOME=/opt/IBM/java8
export PATH="$GRADLE2_HOME/bin:$PATH"
gradle build
ls -al build/libs
cp manifest.yml build/libs/
mv build/libs/$BUILD_ID.jar build/libs/CapitalReporting.jar
ls -al build/libs


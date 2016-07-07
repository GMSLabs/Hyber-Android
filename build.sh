#!/bin/bash

# Exit on error
set -e

# List of all samples
samples=( HyberStarterProject )

# Limit memory usage
OPTS='-Dorg.gradle.jvmargs="-Xmx2048m -XX:+HeapDumpOnOutOfMemoryError"'

# Work off travis
if [[ -v TRAVIS_PULL_REQUEST ]]; then
  echo "TRAVIS_PULL_REQUEST: $TRAVIS_PULL_REQUEST"
else
  echo "TRAVIS_PULL_REQUEST: unset, setting to false"
  TRAVIS_PULL_REQUEST=false
fi

for sample in "${samples[@]}"
do
  echo "Building ${sample}"

  # Go to sample directory
  cd ${sample}

  # Copy mock google-services file if necessary
  if [ ! -f ./${sample}/google-services.json ]; then
    echo "Using mock google-services.json"
    cp ../mock-google-services.json ./google-services.json
  fi

  # Build
  if [ ${TRAVIS_PULL_REQUEST} = false ] ; then
    # For a merged commit, build all configurations.
    GRADLE_OPTS=${OPTS} ../gradlew clean build
  else
    # On a pull request, just build debug which is much faster and catches
    # obvious errors.
    GRADLE_OPTS=${OPTS} ../gradlew clean :${sample}:assembleDebug
  fi

  # Back to parent directory.
  cd -
done

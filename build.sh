#!/bin/bash

PROJ=red-black-tree

pushd build

javac -d . ../src/$PROJ/*.java

java RedBlackTreeDemo

popd

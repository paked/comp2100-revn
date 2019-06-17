#!/bin/bash

pushd build

javac -d . ../src/binary-search-tree/*.java

java BinarySearchTreeTest

popd

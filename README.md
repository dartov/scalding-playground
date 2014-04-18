# Scalding Playground [![Build Status](https://travis-ci.org/dartov/scalding-playground.png)](https://travis-ci.org/dartov/scalding-playground)

## Introduction

This is a ripped of version off [Snowplow's sample scalding project] [scalding-example-project], many thanks to them for it!

## Unit testing

Simply run:

    sbt test

In order to autotest (run continuously, watching for source changes) you need to run it in some terminal session:

    sbt '~test'

## Running on cluster

First, you need to package fat jar:

    sbt assembly

Run somewhere with `hadoop jar` available:

    hadoop jar target/scala-2.10/scalding-example-project-assembly-0.0.1.jar net.aystech.scalding.WordCountJob --hdfs --input some/input/file --output some/output/file


[scalding-example-project]: https://github.com/snowplow/scalding-example-project

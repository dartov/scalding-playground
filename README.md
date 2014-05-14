# Scalding Playground [![Build Status](https://travis-ci.org/dartov/scalding-playground.png)](https://travis-ci.org/dartov/scalding-playground)

## Introduction

This is a ripped off version of [Snowplow's sample scalding project] [scalding-example-project], many thanks to them for it!

## Unit testing

Simply run:

    sbt test

In order to autotest (run continuously, watching for source changes) you need to run it in some terminal session:

    sbt '~test'

## Running on cluster

First, you need to package fat jar:

    sbt assembly

Run somewhere with `hadoop jar` available:

    hadoop jar target/scala-2.10/scalding-playground-assembly-0.0.1.jar net.aystech.scalding.WordCountJob --hdfs --input some/input/file --output some/output/file


## To Do

It'll be great to extend this with some other examples, feel free to contribute your pull request. Please include simple and concise tests, also some test data  would be nice.

- Avro file read & write
- Parquet file read & write
- Using GlobHfs
- Run some arbitrary code traversing HDFS for multiple source paths
- Use Pattern or any other way to apply PMML model within workflow

[scalding-example-project]: https://github.com/snowplow/scalding-example-project

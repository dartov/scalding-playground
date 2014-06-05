import sbt._

object Dependencies {
  val resolutionRepos = Seq(
    "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
    "releases" at "http://oss.sonatype.org/content/repositories/releases",
    "Concurrent Maven Repo" at "http://conjars.org/repo",
    "Clojars Repository" at "http://clojars.org/repo",
    "Twitter Maven" at "http://maven.twttr.com"
  )

  object V {
    val scalding  = "0.10.0"
    val hadoop    = "1.2.1" // Currently scalding doesn't support Hadoop2, this is current known safe version
    val specs2    = "2.3.11"
  }

  object Libraries {
    val scaldingCore = "com.twitter"                %%  "scalding-core"       % V.scalding
    val hadoopCore   = "org.apache.hadoop"          % "hadoop-core"           % V.hadoop       % "provided"

    val specs2       = "org.specs2"                 %% "specs2"               % V.specs2       % "test"
  }
}

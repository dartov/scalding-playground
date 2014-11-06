import sbt._
import Keys._

object BuildSettings {

  // Basic settings for our app
  lazy val basicSettings = Seq[Setting[_]](
    organization  := "AYSTech Consulting",
    version       := "0.0.1",
    description   := "Sample playground project to try different scalding stuff",
    scalaVersion  := "2.10.4",
    scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
    resolvers     ++= Dependencies.resolutionRepos
  )

  // sbt-assembly settings for building a fat jar
  import sbtassembly.Plugin._
  import AssemblyKeys._
  lazy val sbtAssemblySettings = assemblySettings ++ Seq(

    // Drop these jars
    excludedJars in assembly <<= (fullClasspath in assembly) map {
      cp =>
        val excludes = Set(
          "jsp-api-2.1-6.1.14.jar",
          "jsp-2.1-6.1.14.jar",
          "jasper-compiler-5.5.12.jar",
          "minlog-1.2.jar", // Otherwise causes conflicts with Kyro (which bundles it)
          "janino-2.6.1.jar", // Janino includes a broken signature, and is not needed anyway
          "commons-beanutils-core-1.8.0.jar", // Clash with each other and with commons-collections
          "commons-beanutils-1.7.0.jar"
        )
        cp filter {
          jar => excludes(jar.data.getName)
        }
    },
    // Some of these files have duplicates, let's ignore:
    mergeStrategy in assembly <<= (mergeStrategy in assembly) {
      (old) => {
        case s if s.endsWith(".class") => MergeStrategy.last
        case s if s.endsWith("project.clj") => MergeStrategy.concat
        case s if s.endsWith(".html") => MergeStrategy.last
        case s if s.endsWith(".dtd") => MergeStrategy.last
        case s if s.endsWith(".xsd") => MergeStrategy.last
        case s if s.endsWith(".jnilib") => MergeStrategy.rename
        case s if s.endsWith("jansi.dll") => MergeStrategy.rename
        case x => old(x)
      }
    }
  )

  lazy val buildSettings = basicSettings ++ sbtAssemblySettings
}
name := "nel"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/nel"))

startYear := Some(2017)

organizationName := "Evolution"

organizationHomepage := Some(url("http://evolution.com"))

scalaVersion := crossScalaVersions.value.last

crossScalaVersions := Seq("3.2.2", "2.12.17", "2.13.10")

Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-no-link-warnings")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.15" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

publishTo := Some(Resolver.evolutionReleases)

releaseCrossBuild := true
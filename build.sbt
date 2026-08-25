name := "nel"

organization := "com.evolutiongaming"

homepage := Some(url("https://github.com/evolution-gaming/nel"))

startYear := Some(2017)

organizationName := "Evolution"

organizationHomepage := Some(url("https://evolution.com"))

scalaVersion := crossScalaVersions.value.last

crossScalaVersions := Seq("3.3.8", "2.13.18")

Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-no-link-warnings")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.2.20" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

publishTo := Some(Resolver.evolutionReleases)

versionPolicyIntention := Compatibility.BinaryCompatible

addCommandAlias("check", "all scalafmtCheckRepo versionPolicyCheck Compile/doc")
addCommandAlias("fmt", "scalafmtRepo")
addCommandAlias("build", "+all compile test")

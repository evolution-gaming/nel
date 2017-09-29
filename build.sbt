name := "nel"

organization := "com.evolutiongaming"

homepage := Some(new URL("http://github.com/evolution-gaming/nel"))

startYear := Some(2017)

organizationName := "Evolution Gaming"

organizationHomepage := Some(url("http://evolutiongaming.com"))

bintrayOrganization := Some("evolutiongaming")

scalaVersion := "2.12.3"

crossScalaVersions := Seq("2.12.3", "2.11.11")

scalacOptions ++= Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

scalacOptions in (Compile,doc) ++= Seq("-groups", "-implicits", "-no-link-warnings")

resolvers += Resolver.bintrayRepo("evolutiongaming", "maven")

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.4" % Test)

licenses := Seq(("MIT", url("https://opensource.org/licenses/MIT")))

releaseCrossBuild := true
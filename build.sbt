ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.17"

lazy val root = (project in file("."))
  .settings(
    name := "snowflake-practice"
  )
libraryDependencies += "com.typesafe" % "config" % "1.4.3"
libraryDependencies += "net.snowflake" % "snowflake-jdbc" % "3.13.30"

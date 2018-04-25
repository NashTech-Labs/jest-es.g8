name := "Jest-ES"

version := "0.1"

scalaVersion := "2.12.4"

val ES_VERSION = "5.3.3"
val jestClient = "io.searchbox" % "jest" % ES_VERSION
val playJson = "com.typesafe.play" %% "play-json" % "2.6.8"
val es = "org.elasticsearch" % "elasticsearch" % ES_VERSION
val log4jCore = "org.apache.logging.log4j" % "log4j-core" % "2.10.0"
val log4jApi = "org.apache.logging.log4j" % "log4j-api" % "2.10.0"
val slf4jSimple = "org.slf4j" % "slf4j-simple" % "1.7.25"
val mockito = "org.mockito" % "mockito-core" % "2.10.0"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1"

libraryDependencies ++= Seq(
  jestClient,
  playJson,
  es,
  log4jCore,
  log4jApi,
  slf4jSimple,
  mockito % "test",
  scalaTest % "test"
)
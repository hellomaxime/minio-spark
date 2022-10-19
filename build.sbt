ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "minio-spark"
  )

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % "3.3.0" % "provided",
  "io.minio" % "minio" % "8.4.5",
  "org.apache.hadoop" % "hadoop-aws" % "3.3.3"
)
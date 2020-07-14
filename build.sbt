name := "SparkTestApp"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.4.6" % "runtime"


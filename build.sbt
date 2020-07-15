name := "SparkTestApp"

version := "0.1"

scalaVersion := "2.12.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.0"
libraryDependencies += "org.apache.spark" %% "spark-graphx" % "3.0.0"
//libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.6"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.0.0"

//libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka" % "1.6.3"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.0.0"
//libraryDependencies += "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.3.0"
//libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.5.0"
//libraryDependencies += "com.squareup.retrofit2" % "converter-gson" % "2.3.0"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "2.5.0"



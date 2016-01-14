name := "finagle-userservice"

version := "1.0"

parallelExecution in ThisBuild := false


lazy val versions = new {
  val finagle = "6.31.0"
  val scroogeVersion = "4.2.0"
}

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  "Twitter Maven" at "https://maven.twttr.com"
)

val scroogeLibs = Seq(
  "org.apache.thrift" % "libthrift" % "0.8.0",
  "com.twitter" %% "finagle-thrift" % versions.finagle,
  "com.twitter" %% "finagle-thriftmux" % versions.finagle,
  "com.twitter" %% "scrooge-core" % versions.scroogeVersion)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "com.twitter" %% "finagle-core" %  versions.finagle,
  "com.twitter" %% "finagle-http" %  versions.finagle,
  "com.twitter" %% "finagle-serversets" %   versions.finagle
)

libraryDependencies ++= scroogeLibs
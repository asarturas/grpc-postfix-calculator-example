name := "exercise-postfix-calculator"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % "1.5.0",
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % "0.6.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)
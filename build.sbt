import Dependencies.*

val scala3Version = "3.3.1"

lazy val commonSettings = Seq(
  scalafmtOnCompile := true
)

lazy val root = project.in(file("."))
  .settings(
    name := "tasks-service",
    version := "0.1.0-SNAPSHOT",
  )
  .aggregate(tasksService)



lazy val tasksService = project.in(file("modules/service"))
  .settings(commonSettings)
  .settings(
    name := "tasks-svc",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(munit),
  )

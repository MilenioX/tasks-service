import Dependencies.*

val scala3Version = "3.3.1"

val dockerImage = sys.env.getOrElse("JDK_17_DOCKER_IMAGE", s"openjdk:17-jdk-slim-buster")

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
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings)
  .settings(
    name                    := "tasks-svc",
    scalaVersion            := scala3Version,
    Docker / packageName    := "tasks-service",
    dockerBaseImage         := s"$dockerImage",
    dockerExposedPorts      := Seq(8080),
    dockerAliases           := Seq(
      dockerAlias.value.withTag(Some("latest"))
    ),
    libraryDependencies ++= Seq(munit),
  )

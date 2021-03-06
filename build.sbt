lazy val scalaTestV = "3.2.5"
lazy val catsEffectV = "2.5.1"
lazy val fs2V = "2.5.3"

lazy val root = (project in file("."))
  .settings(
    name := "example",
    scalaVersion := "2.13.5",
    sbtVersion := "1.5.4",
    organization := "io.github.mjftw",
    version := "0.1.0",
    scalafixOnCompile := true,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions ++= Seq(
      "-Ywarn-unused",
      "-feature",
      "-deprecation",
      "-unchecked",
      "-language:postfixOps"
    ),
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % catsEffectV,
      "org.typelevel" %% "cats-effect-kernel" % catsEffectV,
      "co.fs2" %% "fs2-core" % fs2V,
      "co.fs2" %% "fs2-io" % fs2V,
      "co.fs2" %% "fs2-reactive-streams" % fs2V,
      "org.typelevel" %% "cats-effect-laws" % catsEffectV % Test,
      "org.scalatest" %% "scalatest" % scalaTestV % Test
    )
  )

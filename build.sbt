lazy val scalaTestV = "3.2.5"
lazy val catsEffectV = "3.1.1"

lazy val root = (project in file("."))
  .settings(
    name := "ce3-sandbox",
    scalaVersion := "2.13.5",
    sbtVersion := "1.5.4",
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
      "org.typelevel" %% "cats-effect-laws" % catsEffectV % Test,
      "org.scalatest" %% "scalatest" % scalaTestV % Test
    )
  )

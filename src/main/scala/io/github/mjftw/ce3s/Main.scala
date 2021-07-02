package io.github.mjftw.ce3s

import cats.effect.{IO, IOApp, ExitCode}

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    IO.println("App running!").as(ExitCode.Success)
}

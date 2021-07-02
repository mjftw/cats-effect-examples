package io.github.mjftw.example

import cats.effect.{IO, IOApp, ExitCode}

object Example extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- IO(println("Hello Example!!"))
    } yield ExitCode.Success
}

package io.github.mjftw.example

import cats.effect.{IO, IOApp, ExitCode}

object IOAppExample extends IOApp {
  def run(args: List[String]): IO[ExitCode] =
    for {
      _ <- IO(println("Hello world!"))
    } yield ExitCode.Success
}

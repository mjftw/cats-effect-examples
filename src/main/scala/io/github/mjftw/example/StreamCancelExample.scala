package io.github.mjftw.example

import fs2.Stream
import scala.concurrent.duration._
import cats.effect.{IO, IOApp, ExitCode}

object StreamCancelExample extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {

    val program = IO(println(s"Tick: ${System.currentTimeMillis}")) >>
      IO.sleep(1.second) >>
      IO(println("Tock"))

    val stream = Stream.eval(program).repeat

    for {
      _ <- IO(println("Starting fiber"))
      fiber <- stream.compile.drain.start
      _ <- IO.sleep(3.seconds)
      _ <- IO(println("Cancelling fiber"))
      _ <- fiber.cancel
      _ <- IO(println("Stream IO cancelled"))
    } yield ExitCode.Success
  }
}

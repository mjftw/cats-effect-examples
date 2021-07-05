package io.github.mjftw.example

import fs2.Stream
import scala.concurrent.duration._
import cats.effect.{IO, IOApp, ExitCode}

object StreamRaceExample extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {

    val program = IO(println(s"Tick: ${System.currentTimeMillis}")) >>
      IO.sleep(1.second) >>
      IO(println("Tock"))

    val stream = Stream.eval(program).repeat

    for {
      _ <- IO(println("Starting race"))
      _ <- IO.race(stream.compile.drain, IO.sleep(3.seconds))
      _ <- IO(println("Stream IO cancelled"))
    } yield ExitCode.Success
  }
}

package com.mundox.tasks.main

object Main:
  def main(args: Array[String]): Unit =
    println(grettings("world"))

  def grettings(name: String): String =
    s"Hello $name!"

package com.mundox.tasks.main

import munit.*

class MainSuite extends FunSuite:
  test("testing gretting method") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }

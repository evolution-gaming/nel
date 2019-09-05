package com.evolutiongaming.nel

import org.scalatest.{FunSuite, Matchers}

class NelSpec213 extends FunSuite with Matchers {
  test("to") {
    Nel(1, 2).to(Set) shouldEqual Set(1, 2)
  }
}
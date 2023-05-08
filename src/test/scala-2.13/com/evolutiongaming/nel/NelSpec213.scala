package com.evolutiongaming.nel

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class NelSpec213 extends AnyFunSuite with Matchers {
  test("to") {
    Nel(1, 2).to(Set) shouldEqual Set(1, 2)
  }
}
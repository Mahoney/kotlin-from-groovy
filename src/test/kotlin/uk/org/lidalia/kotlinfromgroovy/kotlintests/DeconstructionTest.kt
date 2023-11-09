package uk.org.lidalia.kotlinfromgroovy.kotlintests

import org.junit.jupiter.api.Test
import uk.org.lidalia.kotlinfromgroovy.testsupport.ClassWithComponents
import uk.org.lidalia.kotlinfromgroovy.testsupport.DataClass

class DeconstructionTest {

  @Test
  fun `can deconstruct a pair`() {

    val (first, second) = Pair("argument1", 2)

    assert(first == "argument1")
    assert(second == 2)
  }

  @Test
  fun `can deconstruct a data class`() {

    val (first, second, third) = DataClass("argument1", 2, true)

    assert(first == "argument1")
    assert(second == 2)
    assert(third)
  }

  @Test
  fun `can partially deconstruct a class`() {

    val (first, second) = DataClass("argument1", 2, true)

    assert(first == "argument1")
    assert(second == 2)
  }

  @Test
  fun `can deconstruct a normal class with components`() {

    val (first, second) = ClassWithComponents("argument1", 2, true)

    assert(first == "argument1")
    assert(second == 2)
  }

  @Test
  fun `cannot deconstruct when too many components`() {
//        val (first, second, third) = ClassWithComponents("argument1", 2, true)
  }

  @Test
  fun `typed deconstruction works`() {
    val (first: String, second: Int) = ClassWithComponents("argument1", 2, true)

    assert(first == "argument1")
    assert(second == 2)
  }

  @Test
  fun `typed deconstruction fails for wrong type`() {
//        val (first: String, second: String) = ClassWithComponents("argument1", 2, true)
  }
}

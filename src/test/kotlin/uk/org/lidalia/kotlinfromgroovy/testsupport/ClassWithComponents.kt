package uk.org.lidalia.kotlinfromgroovy.testsupport

@Suppress("MemberVisibilityCanBePrivate")
class ClassWithComponents(
  val property1: String,
  val property2: Int,
  @Suppress("unused")
  val property3: Boolean,
) {

  operator fun component1() = property1

  operator fun component2() = property2
}

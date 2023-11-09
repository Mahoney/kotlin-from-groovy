package uk.org.lidalia.kotlinfromgroovy.testsupport

data class DataClass(
  val argument1: String,
  val argument2: Int,
  val argument3: Boolean,
)

data class DataClassWithDefaultValues(
  val argument1: String = "argument1",
  val argument2: String = "argument2",
)

data class DataClassWithCustomCopyMethod(
  val argument1: String,
  val argument2: Int,
) {
  fun copy(argument1: String) = DataClassWithCustomCopyMethod(argument1, 5)
}

data class DataClassWithSingleMap(
  val argument1: Map<String, Any> = mapOf("argument1" to "value1"),
)

data class DataClassWithMapAsFirstProperty(
  val argument1: Map<String, Any> = mapOf("argument1" to "value1"),
  val argument2: String = "argument2",
)

data class DataClassWithMapAsSecondProperty(
  val argument1: String = "argument1",
  val argument2: Map<String, Any> = mapOf("argument2" to "value2"),
)

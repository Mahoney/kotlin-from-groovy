package uk.org.lidalia.kotlinfromgroovy.testsupport

data class Call(
  val functionName: String,
  val arguments: LinkedHashMap<String, Any?>,
)

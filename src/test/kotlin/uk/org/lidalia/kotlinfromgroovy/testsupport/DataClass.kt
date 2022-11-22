package uk.org.lidalia.kotlinfromgroovy.testsupport

data class DataClass(
    val argument1: String,
    val argument2: Int,
    val argument3: Boolean,
)

data class DataClassWithDefaultValues(
    val argument1: String = "",
    val argument2: Int? = null,
    val argument3: Boolean,
)

data class DataClassWithCustomCopyMethod(
    val argument1: String,
    val argument2: Int,
) {
    fun copy(argument1: String) = DataClassWithCustomCopyMethod(argument1, 5)
}

package uk.org.lidalia.kotlinfromgroovy.kotlintests

import org.junit.jupiter.api.Test
import uk.org.lidalia.kotlinfromgroovy.testsupport.DataClassWithDefaultValues

class DataClassConstructorArgumentsTest {

    @Test
    fun `can construct a data class with default arguments`() {

        val instance = DataClassWithDefaultValues()

        assert(instance.argument1 == "argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct a data class with default arguments with one positional argument`() {

        val instance = DataClassWithDefaultValues("different argument1")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct a data class with default arguments with two positional arguments`() {

        val instance = DataClassWithDefaultValues("different argument1", "different argument2")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct a data class with default arguments with first named argument`() {

        val instance = DataClassWithDefaultValues(argument1 = "different argument1")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct a data class with default arguments with second named argument`() {

        val instance = DataClassWithDefaultValues(argument2 = "different argument2")

        assert(instance.argument1 == "argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct a data class with default arguments with both named arguments`() {

        val instance = DataClassWithDefaultValues(
            argument1 = "different argument1",
            argument2 = "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct a data class with default arguments with both named arguments in wrong order`() {

        val instance = DataClassWithDefaultValues(
            argument2 = "different argument2",
            argument1 = "different argument1",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct a data class with named argument and subsequent positional arguments`() {

        val instance = DataClassWithDefaultValues(
            argument1 = "different argument1",
            "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct a data class with positional and subsequent positionally correct named argument`() {

        val instance = DataClassWithDefaultValues(
            "different argument1",
            argument2 = "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `cannot construct a data class with positional and named arguments in wrong order`() {

//        val instance = DataClassWithDefaultValues(
//            argument2 = "different argument2",
//            "different argument1",
//        )
    }

    @Test
    fun `cannot construct a data class with positional and named arguments in wrong order 2`() {

//        val instance = DataClassWithDefaultValues(
//            "different argument1",
//            argument1 = "different argument1",
//        )
    }
}

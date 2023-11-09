package uk.org.lidalia.kotlinfromgroovy.kotlintests

import org.junit.jupiter.api.Test
import uk.org.lidalia.kotlinfromgroovy.testsupport.ClassWithDefaultProperties

class ConstructorArgumentsTest {

    @Test
    fun `can construct an instance with default arguments`() {

        val instance = ClassWithDefaultProperties()

        assert(instance.argument1 == "argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct an instance with default arguments with one positional argument`() {

        val instance = ClassWithDefaultProperties("different argument1")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct an instance with default arguments with two positional arguments`() {

        val instance = ClassWithDefaultProperties("different argument1", "different argument2")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct an instance with default arguments with first named argument`() {

        val instance = ClassWithDefaultProperties(argument1 = "different argument1")

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "argument2")
    }

    @Test
    fun `can construct an instance with default arguments with second named argument`() {

        val instance = ClassWithDefaultProperties(argument2 = "different argument2")

        assert(instance.argument1 == "argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct an instance with default arguments with both named arguments`() {

        val instance = ClassWithDefaultProperties(
            argument1 = "different argument1",
            argument2 = "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct an instance with default arguments with both named arguments in wrong order`() {

        val instance = ClassWithDefaultProperties(
            argument2 = "different argument2",
            argument1 = "different argument1",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct an instance with named argument and subsequent positional arguments`() {

        val instance = ClassWithDefaultProperties(
            argument1 = "different argument1",
            "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `can construct an instance with positional and subsequent positionally correct named argument`() {

        val instance = ClassWithDefaultProperties(
            "different argument1",
            argument2 = "different argument2",
        )

        assert(instance.argument1 == "different argument1")
        assert(instance.argument2 == "different argument2")
    }

    @Test
    fun `cannot construct an instance with positional and named arguments in wrong order`() {

//        val instance = ClassWithDefaultProperties(
//            argument2 = "different argument2",
//            "different argument1",
//        )
    }

    @Test
    fun `cannot construct an instance with positional and named arguments in wrong order 2`() {

//        val instance = ClassWithDefaultProperties(
//            "different argument1",
//            argument1 = "different argument1",
//        )
    }

    @Test
    fun `cannot construct an instance with an incorrect argument`() {

//        val instance = ClassWithDefaultProperties(
//            argument3 = "does not exist",
//        )
    }
}

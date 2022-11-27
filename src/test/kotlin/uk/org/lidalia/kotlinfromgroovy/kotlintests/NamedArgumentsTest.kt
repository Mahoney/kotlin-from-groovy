package uk.org.lidalia.kotlinfromgroovy.kotlintests

import org.junit.jupiter.api.Test
import uk.org.lidalia.kotlinfromgroovy.testsupport.Call
import uk.org.lidalia.kotlinfromgroovy.testsupport.ClassWithNoDefaultedArgumentsToMethods

class NamedArgumentsTest {

    private val classUnderTest = ClassWithNoDefaultedArgumentsToMethods()

    @Test
    fun `can call a method using named arguments`() {

        classUnderTest.functionWithMultipleArguments(
            argument1 = "argument1",
            argument2 = 2,
            argument3 = true
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithMultipleArguments",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to 2,
                    "argument3" to true
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes a Map`() {

        classUnderTest.functionWithMapArgument(
            mapOf("entry1" to "entry1"),
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithMapArgument",
                linkedMapOf(
                    "argument1" to mapOf("entry1" to "entry1")
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes a Map using named arguments`() {

        classUnderTest.functionWithMapArgument(
            argument1 = mapOf("entry1" to "entry1"),
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithMapArgument",
                linkedMapOf(
                    "argument1" to mapOf("entry1" to "entry1")
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes a Map and another arg`() {

        classUnderTest.functionWithMapAndOtherArgument(
            mapOf("entry1" to "entry1"),
            "argument2",
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithMapAndOtherArgument",
                linkedMapOf(
                    "argument1" to mapOf("entry1" to "entry1"),
                    "argument2" to "argument2"
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes a Map and another arg using named arguments`() {

        classUnderTest.functionWithMapAndOtherArgument(
            argument1 = mapOf("entry1" to "entry1"),
            argument2 = "argument2",
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithMapAndOtherArgument",
                linkedMapOf(
                    "argument1" to mapOf("entry1" to "entry1"),
                    "argument2" to "argument2"
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes another arg and a Map`() {

        classUnderTest.functionWithOtherAndMapArgument(
            "argument1",
            mapOf("entry1" to "entry1"),
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOtherAndMapArgument",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to mapOf("entry1" to "entry1"),
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes another arg and a Map using named arguments`() {

        classUnderTest.functionWithOtherAndMapArgument(
            argument1 = "argument1",
            argument2 = mapOf("entry1" to "entry1"),
        )

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOtherAndMapArgument",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to mapOf("entry1" to "entry1"),
                )
            )
        ))
    }

    @Test
    fun `can call a method that takes a LinkedHashMap`() {

        classUnderTest.functionWithLinkedMapArgument(
            linkedMapOf(
                "entry1" to "entry1",
            ))

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithLinkedMapArgument",
                linkedMapOf(
                    "argument1" to mapOf("entry1" to "entry1")
                )
            )
        ))
    }

    @Test
    fun `cannot call a method with an incorrect argument`() {

//        classUnderTest.functionWithMultipleArguments(argument4 = "does not exist")
    }
}

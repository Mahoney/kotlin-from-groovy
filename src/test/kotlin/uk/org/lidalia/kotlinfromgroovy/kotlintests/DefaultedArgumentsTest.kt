package uk.org.lidalia.kotlinfromgroovy.kotlintests

import org.junit.jupiter.api.Test
import uk.org.lidalia.kotlinfromgroovy.testsupport.Call
import uk.org.lidalia.kotlinfromgroovy.testsupport.ClassWithDefaultedArgumentsToMethods

class DefaultedArgumentsTest {

    private val classUnderTest = ClassWithDefaultedArgumentsToMethods()

    @Test
    fun `can call functionWithOneDefaultedArgument with 0 args`() {

        classUnderTest.functionWithOneDefaultedArgument()

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneDefaultedArgument",
                linkedMapOf(
                    "argument1" to "argument1",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneDefaultedArgument with 1st positional arg`() {

        classUnderTest.functionWithOneDefaultedArgument("different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneDefaultedArgument",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneDefaultedArgument with 1st named arg`() {

        classUnderTest.functionWithOneDefaultedArgument(argument1 = "different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneDefaultedArgument",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }

    @Test
    fun `cannot call functionWithTwoArgumentFirstDefaulted with no args`() {
//        classUnderTest.functionWithTwoArgumentFirstDefaulted()
    }

    @Test
    fun `cannot call functionWithTwoArgumentFirstDefaulted with 1 positional arg`() {
//        classUnderTest.functionWithTwoArgumentFirstDefaulted("different 1")
    }

    @Test
    fun `can call functionWithTwoArgumentFirstDefaulted with 2nd named arg`() {
        classUnderTest.functionWithTwoArgumentFirstDefaulted(argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentFirstDefaulted",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentFirstDefaulted with 2 positional args`() {
        classUnderTest.functionWithTwoArgumentFirstDefaulted("different 1", "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentFirstDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentFirstDefaulted with 2 named args`() {
        classUnderTest.functionWithTwoArgumentFirstDefaulted(argument1 = "different 1", argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentFirstDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentFirstDefaulted with 1 positional 1 named args`() {
        classUnderTest.functionWithTwoArgumentFirstDefaulted("different 1", argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentFirstDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `cannot call functionWithTwoArgumentFirstDefaulted with mixed positional and named args`() {
//        classUnderTest.functionWithTwoArgumentFirstDefaulted("different 1", argument1 = "different 2")
//        classUnderTest.functionWithTwoArgumentFirstDefaulted(argument2 = "different 1", "different 2")
    }

    @Test
    fun `can call functionWithTwoArgumentFirstDefaulted with 1 named 1 positional args`() {
        classUnderTest.functionWithTwoArgumentFirstDefaulted(argument1 = "different 1", "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentFirstDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `cannot call functionWithTwoArgumentsSecondDefaulted with no args`() {
//        classUnderTest.functionWithTwoArgumentsSecondDefaulted()
    }

    @Test
    fun `can call functionWithTwoArgumentsSecondDefaulted with 1 positional arg`() {
        classUnderTest.functionWithTwoArgumentsSecondDefaulted("different 1")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsSecondDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "argument2",
                )
            )
        ))
    }

    @Test
    fun `cannot call functionWithTwoArgumentsSecondDefaulted with 2nd named arg`() {
//        classUnderTest.functionWithTwoArgumentsSecondDefaulted(argument2 = "different 2")
    }

    @Test
    fun `can call functionWithTwoArgumentsSecondDefaulted with 2 positional args`() {
        classUnderTest.functionWithTwoArgumentsSecondDefaulted("different 1", "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsSecondDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsSecondDefaulted with 2 named args`() {
        classUnderTest.functionWithTwoArgumentsSecondDefaulted(argument1 = "different 1", argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsSecondDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsBothDefaulted with no args`() {
        classUnderTest.functionWithTwoArgumentsBothDefaulted()

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsBothDefaulted",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to "argument2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsBothDefaulted with 1 positional arg`() {
        classUnderTest.functionWithTwoArgumentsBothDefaulted("different 1")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsBothDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "argument2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsBothDefaulted with 2nd named arg`() {
        classUnderTest.functionWithTwoArgumentsBothDefaulted(argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsBothDefaulted",
                linkedMapOf(
                    "argument1" to "argument1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsBothDefaulted with 2 positional args`() {
        classUnderTest.functionWithTwoArgumentsBothDefaulted("different 1", "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsBothDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithTwoArgumentsBothDefaulted with 2 named args`() {
        classUnderTest.functionWithTwoArgumentsBothDefaulted(argument1 = "different 1", argument2 = "different 2")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithTwoArgumentsBothDefaulted",
                linkedMapOf(
                    "argument1" to "different 1",
                    "argument2" to "different 2",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNotNull with no args`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNotNull()

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNotNull",
                linkedMapOf(
                    "argument1" to "argument1",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNotNull with one positional null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNotNull(null)

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNotNull",
                linkedMapOf(
                    "argument1" to null,
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNotNull with one positional not null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNotNull("different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNotNull",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNotNull with one named null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNotNull(argument1 = null)

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNotNull",
                linkedMapOf(
                    "argument1" to null,
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNotNull with one named not null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNotNull(argument1 = "different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNotNull",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNull with no args`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNull()

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNull",
                linkedMapOf(
                    "argument1" to null,
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNull with one positional null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNull(null)

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNull",
                linkedMapOf(
                    "argument1" to null,
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNull with one positional not null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNull("different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNull",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNull with one named null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNull(argument1 = null)

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNull",
                linkedMapOf(
                    "argument1" to null,
                )
            )
        ))
    }

    @Test
    fun `can call functionWithOneNullableArgumentDefaultedToNull with one named not null arg`() {

        classUnderTest.functionWithOneNullableArgumentDefaultedToNull(argument1 = "different")

        assert(classUnderTest.calls == listOf(
            Call(
                "functionWithOneNullableArgumentDefaultedToNull",
                linkedMapOf(
                    "argument1" to "different",
                )
            )
        ))
    }
}

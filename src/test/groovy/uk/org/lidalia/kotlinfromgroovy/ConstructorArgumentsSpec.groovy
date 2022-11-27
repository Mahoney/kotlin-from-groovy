package uk.org.lidalia.kotlinfromgroovy


import spock.lang.Specification
import uk.org.lidalia.kotlinfromgroovy.testsupport.ClassWithDefaultProperties

class ConstructorArgumentsSpec extends Specification {

    def 'can construct a data class with default arguments'() {

        when:
            def instance = new ClassWithDefaultProperties()

        then:
            assert (instance.argument1 == "argument1")
            assert (instance.argument2 == "argument2")
    }

    def 'can construct a data class with default arguments with one positional argument'() {

        when:
            def instance = new ClassWithDefaultProperties("different argument1")

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "argument2")
    }

    def 'can construct a data class with default arguments with two positional arguments'() {

        when:
            def instance = new ClassWithDefaultProperties("different argument1", "different argument2")

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'can construct a data class with default arguments with first named argument'() {

        when:
            def instance = new ClassWithDefaultProperties(argument1: "different argument1")

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "argument2")
    }

    def 'can construct a data class with default arguments with second named argument'() {

        when:
            def instance = new ClassWithDefaultProperties(argument2: "different argument2")

        then:
            assert (instance.argument1 == "argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'can construct a data class with default arguments with both named arguments'() {

        when:
            def instance = new ClassWithDefaultProperties(
                argument1: "different argument1",
                argument2: "different argument2",
            )

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'can construct a data class with default arguments with both named arguments in wrong order'() {

        when:
            def instance = new ClassWithDefaultProperties(
                argument2: "different argument2",
                argument1: "different argument1",
            )

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'can construct a data class with named argument and subsequent positional arguments'() {

        when:
            def instance = new ClassWithDefaultProperties(
                argument1: "different argument1",
                "different argument2",
            )

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'can construct a data class with positional and subsequent positionally correct named argument'() {

        when:
            def instance = new ClassWithDefaultProperties(
                "different argument1",
                argument2: "different argument2",
            )

        then:
            assert (instance.argument1 == "different argument1")
            assert (instance.argument2 == "different argument2")
    }

    def 'cannot construct a data class with positional and named arguments in wrong order'() {

        when:
            def instance = new ClassWithDefaultProperties(
                argument2: "different argument2",
                "different argument1",
            )


        then:
            def exception = thrown(IllegalArgumentException)
            exception.message == 'Mixing named and positioned arguments is not allowed'
    }

    def 'cannot construct a data class with positional and named arguments in wrong order 2'() {

        when:
            def instance = new ClassWithDefaultProperties(
                "different argument1",
                argument1: "different argument1",
            )


        then:
            def exception = thrown(IllegalArgumentException)
            exception.message == 'An argument is already passed for this parameter'
    }
}

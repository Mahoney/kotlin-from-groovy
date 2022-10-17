package uk.org.lidalia.kotlinfromgroovy

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.expr.DeclarationExpression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.NamedArgumentListExpression
import org.codehaus.groovy.ast.expr.TupleExpression
import org.codehaus.groovy.ast.stmt.BlockStatement
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.AbstractASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase= CompilePhase.SEMANTIC_ANALYSIS)
class KotlinDataClassCopyMethodASTTransformation : AbstractASTTransformation() {

    override fun visit(nodes: Array<ASTNode>, source: SourceUnit) {
        val namedArgumentMethodCalls = source.findNamedArgumentMethodCalls()


        if (namedArgumentMethodCalls.isNotEmpty()) {
            println(source.name)
            println(namedArgumentMethodCalls.joinToString(",\n  ", "[\n  ", "\n]"))
        }
    }

    private fun SourceUnit.findNamedArgumentMethodCalls(): List<MethodCallExpression> = ast.classes.map { classNode ->

        val fieldInitialiseMethodCalls = classNode.fields.mapNotNull { fieldNode ->
            if (fieldNode.hasInitialExpression()) {
                val initialExpression = fieldNode.initialExpression
                if (initialExpression is MethodCallExpression) {
                    filterMethodCallExpression(initialExpression)
                } else null
            } else null
        }

        val inMethodCalls = classNode.methods.mapNotNull { methodNode ->
            val code = methodNode.code
            if (code is BlockStatement) {
                code.statements
                        .filterIsInstance<ExpressionStatement>()
                        .mapNotNull { expressionStatement ->
                            when (val expression = expressionStatement.expression) {
                                is MethodCallExpression -> filterMethodCallExpression(expression)
                                is DeclarationExpression -> {
                                    when (val rightExpression = expression.rightExpression) {
                                        is MethodCallExpression -> filterMethodCallExpression(rightExpression)
                                        else -> null
                                    }
                                }

                                else -> null
                            }
                        }
            } else null
        }
        .flatten()

        fieldInitialiseMethodCalls + inMethodCalls
    }.flatten()

    private fun filterMethodCallExpression(initialExpression: MethodCallExpression): MethodCallExpression? {
        val arguments = initialExpression.arguments
        return if (arguments is TupleExpression && (arguments.expressions.singleOrNull() is NamedArgumentListExpression)) {
            initialExpression
        } else null
    }
}

/*
if (source.name.endsWith('ExperimentSpec.groovy')) {
            println(source.name)
            source.AST.classes.each { classNode ->
                println(classNode)
                println("**** FIELDS")
                classNode.fields.each { field ->
                    println(field.initialExpression)
                }
                println("**** METHODS")
                classNode.methods
//                    .findAll { it.code instanceof BlockStatement }
                    .each { method ->
                        println(method)
                        println(method.code)
//                        def existingStatements = ((BlockStatement) method.code).statements
//                        existingStatements.each {
//                            println('it')
//                            println(it)
//                        }
//                        existingStatements
//                            .findAll { it instanceof ExpressionStatement && it.expression instanceof MethodCallExpression }
//                            .each { existingStatement ->
//                                def methodCall = (existingStatement as ExpressionStatement).expression as MethodCallExpression
//                                println(methodCall)
//                                println(methodCall.arguments)
//                            }
                    }
            }
        }
 */
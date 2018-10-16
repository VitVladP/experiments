package com.client.log

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class Aop {

    val log = LoggerFactory.getLogger(Aop::class.java)

    @Around("execution(* com.client.log.Spiker.*(..))")
    fun check(jp:ProceedingJoinPoint): Any?{
        val signature = jp.signature

        log.error("input method: ${jp.signature.name}  ${getStringFromArgs(jp.args)}")
        val proceed = jp.proceed()
        log.error("output method: ${jp.signature.name} result: ${resultToString(proceed)}")
        return proceed
    }

    fun getStringFromArgs(args: Array<Any>) =
         if (args.isEmpty())
             ""
            else
             "parameters: " + args.map{ it.toString() }.toString()


    fun resultToString(result: Any?): String =
        result?.toString() ?: "null"
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class LogIgnore
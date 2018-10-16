package com.client.log

import org.springframework.stereotype.Component

@Component
class Spiker(
    var text: String = "fuck"
    ) {


     fun saySomething(data: String, user: User): User {
        val us = User(user.name + data, 20)
        return us
    }

    @LogIgnore
    fun say(){
        println("fuck you!!")
    }
}

data class User(
    val name: String,
    val age: Int)



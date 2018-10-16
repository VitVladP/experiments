package com.client.controller

import com.client.log.User
import com.client.log.Spiker
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController (val spiker:Spiker) {

    @RequestMapping("/")
    fun mainPage(): String{
        return "index + test"
    }

    @RequestMapping("/index")
    fun indexPage(): String {
        spiker.saySomething("text from controller", User("Vetal", 13))
        return "index and some text"
    }

    @RequestMapping("/say")
    fun sayPage(): String {
        spiker.say()
        return "true"
    }
}


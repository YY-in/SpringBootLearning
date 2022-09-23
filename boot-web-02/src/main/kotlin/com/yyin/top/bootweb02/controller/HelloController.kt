package com.yyin.top.bootweb02.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @RequestMapping(value = arrayOf("/user"),method = arrayOf(RequestMethod.GET))
    fun getUser():String{
        return "GET-YYin"
    }

    @RequestMapping(value = arrayOf("/user"),method = [RequestMethod.POST])
    fun saveUser(): String {
        return "POST-YYin"
    }


    @RequestMapping(value = arrayOf("/user"),method = arrayOf(RequestMethod.PUT))
    fun putUser():String{
        return "PUT-YYin"
    }

    @RequestMapping("/user",method = [RequestMethod.DELETE])
    fun deleteUser(): String {
        return "DELETE-YYin"
    }
}
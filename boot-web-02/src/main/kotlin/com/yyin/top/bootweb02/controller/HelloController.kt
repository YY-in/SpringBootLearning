package com.yyin.top.bootweb02.controller

import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.filter.reactive.HiddenHttpMethodFilter

@RestController
class HelloController {
    // 是一个用来处理请求地址映射的注解
    @RequestMapping(value = ["/user"],method = [RequestMethod.GET])
    fun getUser():String{
        return "GET-YYin"
    }

    @RequestMapping(value = ["/user"],method = [RequestMethod.POST])
    fun saveUser(): String {
        return "POST-YYin"
    }


    @RequestMapping(value = ["/user"],method = [RequestMethod.PUT])
    fun putUser():String{
        return "PUT-YYin"
    }

    @RequestMapping("/user",method = [RequestMethod.DELETE])
    fun deleteUser(): String {
        return "DELETE-YYin"
    }

    // 自定義filter
//    @Bean
//    fun hiddenHttpMethodFilter() : HiddenHttpMethodFilter{
//        val methodFilter = HiddenHttpMethodFilter()
//        methodFilter.setMethodParamName("_m")
//        return methodFilter
//    }

}
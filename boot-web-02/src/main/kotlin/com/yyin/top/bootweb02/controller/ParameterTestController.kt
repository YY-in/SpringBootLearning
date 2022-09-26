package com.yyin.top.bootweb02.controller

import org.springframework.web.bind.annotation.*
import javax.servlet.http.Cookie

@RestController
class ParameterTestController {

    //獲取請求的路徑變量
    @GetMapping("/car/{id}/owner/{username}")
    fun getCar(
        //获取路径变量里的值,需要与属性名保持一致
        @PathVariable("id") id: Int,
        @PathVariable("username") name: String,
        //Map<String,String>
        @PathVariable pv: Map<String, String>,

        //获取请求头
        //获取请求头中的某个特殊字段
        @RequestHeader("User-Agent") userAgent: String,
        /**
         * If the method parameter is
         * Map<String, String>, MultiValueMap<String, String>, or HttpHeaders
         * then the map is populated with all header names and values.
         */
        @RequestHeader header: Map<String, String>,

        //获取请求参数
        @RequestParam("age") age: Int,
        //我们感兴趣的参数是一个List，我们也可以直接获取
        @RequestParam("inters") inters: List<String>,
        @RequestParam params: Map<String, String>,

        //获取Cookie
        @CookieValue("_ga") _ga: String,
        @CookieValue("ga") cookie: Cookie
    ): Map<String, Any> {

        val map: HashMap<String, Any> = HashMap<String, Any>()
        //此处定义返回的Json
//        map["Id"] = id
//        map["Name"] = name
//        map["PathVarMap"] = pv
//
//        map["userAgent"] = userAgent
//        map["headers"] = header

        map["age"] = age
        map["inters"] = inters
        map["params"] = params

        map["_ga"] = _ga
        map["cookie"] = cookie
        return map
    }

    //获取 提交表单 的请求数据——单表达式写法
    @PostMapping("/save")
    fun postMethod(@RequestBody content: String) = hashMapOf(content to "content")

    // 处理请求，获取到矩阵变量的值,而不是请求参数
    // 矩阵变量在路径后面以分号的方式传递变量
    // /cars/sell;low=34;brand=byd,audi,yd
    // SpringBoot 默认禁用了矩阵变量的功能 ---> 手动开启

    @GetMapping("/cars/sell")
    fun carsSell(
        @MatrixVariable("low") low: Int,
        @MatrixVariable("brand") brand:List<String>
    ): HashMap<String, Any> {
        val map =hashMapOf<String,Any>()
        map["low"]= low
        map["brand"] = brand
        return map
    }
}



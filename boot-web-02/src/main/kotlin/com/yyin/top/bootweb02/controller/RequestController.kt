package com.yyin.top.bootweb02.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestAttribute
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class RequestController {
    //request域仅在当前请求时有效
    //常用于服务器间同一请求不同页面之间的参数传递，常应用于表单的控件值传递。
    //获取Request域中保存的属性--request域属性
    @GetMapping("/goto")
    fun goToPage(request: HttpServletRequest): String {
        //设置属性
        request.setAttribute("msg","message from gotoPage")
        request.setAttribute("code",200)
        //将当前请求传递到/success路径
        return "forward:/success"
    }

    //@ResponseBody注解表示该方法的返回的结果直接写入 HTTP 响应正文中，一般在异步获取数据时使用；
    @ResponseBody
    @GetMapping("/success")
    fun successPage(
        //获取请求的属性
        @RequestAttribute("msg") msg:String,
        @RequestAttribute("code") code:Int,
        request: HttpServletRequest
    ): HashMap<String, Any> {
        //传统方式获取request当中的属性
        val msg1 = request.getAttribute("msg")
        val map = HashMap<String,Any>()
        map["reqMethod_msg"]=msg1
        //直接利用注解获取属性,
        map["annotation_msg"]=msg
        map["code"]= code
        return map
    }

}
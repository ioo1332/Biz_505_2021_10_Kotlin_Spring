package com.callor.spring.controller

import com.callor.spring.service.OrderService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping(value=["/order"])
class OrderController(val orService:OrderService) {

    //  localhost:8080/order/ 또는
    //  localhost:8080/order 요청을 모두 수용
    @RequestMapping(value=["","/"],method=[RequestMethod.GET])
    fun list(model:Model) : String {
        val salesList = orService.selectAll()
        model["SALES"] = salesList
        return "order/list"
    }
    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("seq") seq: Long): String {

        val order = orService.findById(seq)
        model["SALES"] = order
        return "order/detail" // detail.html 을 열어라

    }

}
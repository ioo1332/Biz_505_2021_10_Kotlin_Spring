package com.callor.readbook.controller

import com.callor.readbook.model.Book
import com.callor.readbook.model.ReadBook
import com.callor.readbook.service.BookService
import com.callor.readbook.service.ReadBookService
import com.callor.readbook.service.impl.BookServiceImplV1
import com.callor.readbook.service.impl.ReadBookServiceImplV1
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value = ["/read"])
class ReadBookController(val bService:BookService,val rService: ReadBookService) {

    val logger = LoggerFactory.getLogger(ReadBookController::class.java)

    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model: Model): String {
        return "write"
    }

    @RequestMapping(value= ["/insert"], method =[RequestMethod.POST])
    fun insert(book:Book, readBook: ReadBook): String {

        bService.insert(book)
        rService.insert(readBook)
        return "redirect:/read/wrtie"
    }
}
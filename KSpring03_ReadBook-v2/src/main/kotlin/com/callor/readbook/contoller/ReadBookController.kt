package com.callor.readbook.contoller

import com.callor.readbook.config.logger
import com.callor.readbook.models.BookDTO
import com.callor.readbook.models.ReadBookDTO
import com.callor.readbook.models.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.impl.ReadBookServiceImplV1
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class ReadBookController(val readBookService:ReadBookServiceImplV1, val readBookDao:ReadBookRepository,val bookDao:BookRepository) {

    @RequestMapping(value = ["","/"],method = [RequestMethod.GET])
    fun home():String{
        return "redirect:/insert"
    }

    @RequestMapping(value = ["/insert"],method = [RequestMethod.GET])
    fun insert():String{
        return "readbook/write.html"
    }

    @RequestMapping(value = ["/insert"],method = [RequestMethod.POST])
    fun insert(readBook: ReadBookVO):String{
        logger().debug(""">
            수신한데이터
            {}""",readBook.toString())

        readBookService.readBookInsert(readBook)

        return "redirect:/insert"
    }
}
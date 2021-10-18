package com.callor.spring.controller.service.impl

import com.callor.spring.controller.service.BuyerService
import com.callor.spring.model.Buyer
import org.springframework.stereotype.Service
import java.util.*

/**
 * BuyerService interface 를 implement 하여 클래스 선언
 */
@Service
class BuyerServiceImpl :BuyerService {
    /**
     * kotlin 클래스내에서 선언되며
     * 클래스가 작동되는데 필요한 필수 데이터나
     * 어떤 옵션을 초기화하는 초기화 블럭 객체
     */
    companion object{
        val rnd= Random(System.currentTimeMillis())
        // map 데이터 생성
        val name=Pair("name","홍길동")
        val id=Pair("id","user")
        val age=Pair("age",30)

        /**
         * Buyer DTD 를 사용하여 3명의 데이터를 선언하고
         * List 배열로 생성
         */
        val userList=arrayOf(
            Buyer(id="admin",name="홍길동",age=30),
            Buyer(id="user",name="이몽룡",age=22),
            Buyer(id="guest",name="성춘향",age=16),
        )
    }


    override fun selectAll():Array<Buyer> {
        return userList
    }

    override fun findById(id: String):Buyer {
        val num=rnd.nextInt(userList.size)
        return userList[num]
    }

}
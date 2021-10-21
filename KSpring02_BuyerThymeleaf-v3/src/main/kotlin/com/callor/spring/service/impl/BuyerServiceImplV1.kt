package com.callor.spring.service.impl

import com.callor.spring.ConfigData
import com.callor.spring.ConfigData.Companion.BUYER_LIST
import com.callor.spring.models.Buyer
import com.callor.spring.repostitory.BuyerRepository
import com.callor.spring.service.BuyerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random

/**
 * 클래스의 매개변수를 사용하여 생성자 주입하기
 * class 클래스(주입받을 객체,변수선언)
 */
@Service("bServiceV1")
class BuyerServiceImplV1(val bRepo:BuyerRepository):BuyerService {
    // setter 주입으로 와이어링하기
    //@Autowired
    //private lateinit var bDao:BuyerRepository
    // 현재 BuyerServiceImplV1에서 사용할 가상 데이터를 선언
    // private: 여기 클래스 내부에서만 사용하는 static 변수 선언하기


    override fun selectAll(): Array<Buyer> {
        return bRepo.findAll().toTypedArray()
    }

    override fun findById(userid: String): Buyer {
        // repository findById()는
        // 실제데이터를 optional 이라는 특별한 객체로 wrapping 하여 가져온다
        // 필요한 데이터는 .get()method를 사용하여
        // 한번 더 추출해주어야한다
        val buyer:Optional<Buyer> =bRepo.findById(userid)
        return buyer.get()
    }

    override fun findByName(name: String): Array<Buyer> {

        return bRepo.findByName(name)
    }

    override fun findByTel(tel: String): Array<Buyer> {
        return bRepo.findByTel(tel)
    }

    override fun insert(buyer: Buyer): Buyer {
        // insert or update
        return bRepo.save(buyer)
    }

    override fun delete(userid: String) {
       bRepo.deleteById(userid)
    }

    override fun update(buyer: Buyer): Buyer {
        return bRepo.save(buyer)
    }
}
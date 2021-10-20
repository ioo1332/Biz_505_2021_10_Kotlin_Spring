package com.callor.spring.repostitory

import com.callor.spring.models.Buyer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
// 현재 BuyerRepository interface를 bean으로 등록하라
// @Repository는 선택적 option
@Repository
interface BuyerRepository:JpaRepository<Buyer,String> {

    /**
     * JpaRepository 를 상속받은 Repository에서
     * 기본 CRUD 외에 다른칼럼으로 조회하는 method를 추가할수있다
     * 단 조건이 있다
     * findBy로 시작해야한다
     * data(Entity)클래스에 정의된 맴버변수 이름만 설정이 가능하다
     */

    fun findByName(name:String):Array<Buyer>
    fun findByTel(name: String):Array<Buyer>

}
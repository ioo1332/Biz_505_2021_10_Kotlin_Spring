package com.callor.spring.models


import java.util.*
import javax.persistence.*

/**
 * id 칼럼을 자동증가 옵션으로 자동생성하기
 * sequence,identify,table,auto
 * sequence: oracle sequence
 * identify: auto_increment가 지원되는 db
 * table : hibernate가 자체적으로 sequence table 을 만들고
 * 증가 값을 관리하도록 하기
 *
 * auto : 사용하는 DBMS 특성에 따라 seq를 만들거나 auto increment 를
 * 생성하여 증가값 관리
 *
 * AUTO 설정을 하면 DB 특성에따라 자체적으로 관리하는데
 * 현재는 그렇지 않고 hibernate_sequence 테이블을 생성하여 JPA가 자체적으로
 * SEQ를 생성하도록 만들어진다
 * auto_increment 가 없는 db에서는 auto로 설정하는것을 권장함
 */
@Entity
@Table(name = "tbl_sales",schema = "naraDB")
data class Sales(
    @Id
    @Column(columnDefinition = "BIGINT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var seq:Long,
    var date:String,
    var time:String,
    var pname:String,
    var qty:Int,
    var amt:Int,
    var total:Int,

    // 데이터에 특별하게 date(날짜,시간) 값을 사용하고 싶을때
    @Temporal(TemporalType.DATE)
    var date1:Date,
    @Temporal(TemporalType.TIME)
    var time1:Date,
    @Temporal(TemporalType.TIMESTAMP)
    var date_time:Date,
)

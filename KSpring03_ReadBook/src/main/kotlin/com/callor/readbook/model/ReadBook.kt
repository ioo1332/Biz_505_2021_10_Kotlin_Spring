package com.callor.readbook.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="tbl_readbook", schema = "naraDB")
data class ReadBook(
    @Id
    @Column(columnDefinition = "BIGINT", nullable = false)
    var seq: String?= null,
    @Column(columnDefinition = "CHAR(4)", nullable = false)
    var isbn: String?= null,
    @Column(columnDefinition = "CHAR(8)", nullable = false)
    var sdate: String?= null,
    @Column(columnDefinition = "CHAR(8)", nullable = false)
    var edate: String?= null,
    @Column(columnDefinition = "CHAR(5)", nullable = false)
    var stime: String?= null,
    @Column(columnDefinition = "CHAR(5)", nullable = false)
    var etime: String?= null,
    @Column(columnDefinition = "CHAR(5)", nullable = false)
    var rating: String?= null,
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    var comment: String?= null,
)
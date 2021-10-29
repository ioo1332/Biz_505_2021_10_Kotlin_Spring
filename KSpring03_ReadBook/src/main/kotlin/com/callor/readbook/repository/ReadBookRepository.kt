package com.callor.readbook.repository

import com.callor.readbook.model.ReadBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface ReadBookRepository:JpaRepository<ReadBook,String> {
   //fun findBy
}
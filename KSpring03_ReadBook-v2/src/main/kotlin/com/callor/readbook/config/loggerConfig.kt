package com.callor.readbook.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * kotlin 에서 사용되는 1급합수
 * 1급함수 : 클래스,객체와 성질이 같은 함수
 *
 * 만약 looger() 함수를 호출하면
 * 호출한 클래스 (객체)를 함수에 전달하고
 * 그 클래스를 getLogger()함수에 매개변수로 부착하여
 * Logger 객체를 생성하여 return하기
 */
inline fun<reified T>T.logger(): Logger =LoggerFactory.getLogger (T::class.java)
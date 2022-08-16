package com.gsoftware.photovoltaicsystemdesign

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class PhotovoltaicSystemDesignApplication

fun main(args: Array<String>) {
	runApplication<PhotovoltaicSystemDesignApplication>(*args)
}

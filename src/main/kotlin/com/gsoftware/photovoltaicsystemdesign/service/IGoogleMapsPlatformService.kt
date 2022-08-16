package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.googleMapsPlatformModel.GoogleMapsPlatformModel
import com.gsoftware.photovoltaicsystemdesign.googleMapsPlatformModel.Result
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "googleMapsPlatform", url = "\${client.google.maps.url}")
interface IGoogleMapsPlatformService {

    @GetMapping("/json")
    fun getResult(
        @RequestParam(name = "address") address: String,
        @RequestParam(name = "components") components: String,
        @RequestParam(name = "key") key: String
    ): GoogleMapsPlatformModel
}
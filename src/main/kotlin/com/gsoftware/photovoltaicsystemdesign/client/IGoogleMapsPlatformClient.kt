package com.gsoftware.photovoltaicsystemdesign.client

import com.gsoftware.photovoltaicsystemdesign.models.googleMapsPlatformModel.GoogleMapsPlatformModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Client do Google Maps Platform
 */
@FeignClient(name = "googleMapsPlatform", url = "\${client.google.maps.url}")
interface IGoogleMapsPlatformClient {

    @GetMapping("/json")
    fun getResult(
        @RequestParam(name = "address") address: String,
        @RequestParam(name = "components") components: String,
        @RequestParam(name = "key") key: String
    ): GoogleMapsPlatformModel
}
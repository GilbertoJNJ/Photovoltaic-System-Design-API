package com.gsoftware.photovoltaicsystemdesign.controller

import com.gsoftware.photovoltaicsystemdesign.googleMapsPlatformModel.Location
import com.gsoftware.photovoltaicsystemdesign.service.IAddressService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AddressRestController(var addressService: IAddressService) {

    @GetMapping()
    fun returnLocation(): ResponseEntity<Location> {
        val location = addressService.returnLocation()
        return ok().body(location)
    }
}
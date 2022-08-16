package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.googleMapsPlatformModel.Location
import com.gsoftware.photovoltaicsystemdesign.service.IAddressService
import com.gsoftware.photovoltaicsystemdesign.service.IGoogleMapsPlatformService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class AddressServiceImpl(
    val googleMapsPlatformService: IGoogleMapsPlatformService
) : IAddressService {

    @Value("\${client.google.maps.credentials.key}")
    lateinit var key: String

    override fun returnLocation(): Location {
        val model = googleMapsPlatformService.getResult(
            "Rua travessa da uniao, 11, Nossa senhora de fatima, Amaraji, PE",
            "country:BR",
            key
        )
        val result = model.results.stream().findAny().get()
        return result.geometry.location
    }
}
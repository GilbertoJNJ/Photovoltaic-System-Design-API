package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.googleMapsPlatformModel.Location

interface IAddressService {
    fun returnLocation(): Location
}

package com.gsoftware.photovoltaicsystemdesign.dto

import java.math.BigDecimal

/**
* Classe DTO que exibe latitude e longetude de uma localização
*
* @param id ID da localização
* @param lat Latitude
* @param lng Longitude
*/
class LocaleDTO(
    var id: Long? = null,
    var lat: BigDecimal? = null,
    var lng: BigDecimal? = null
)

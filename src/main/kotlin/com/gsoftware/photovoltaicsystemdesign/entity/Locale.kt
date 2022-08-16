package com.gsoftware.photovoltaicsystemdesign.entity

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Entidade que representa latitude e longetude de uma localização
 *
 * @param id ID da localização
 * @param lat Latitude
 * @param lng Longitude
 */
@Entity
class Locale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    val lat: BigDecimal? = null,

    @Column
    val lng: BigDecimal? = null
)
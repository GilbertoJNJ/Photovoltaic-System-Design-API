package com.gsoftware.photovoltaicsystemdesign.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Address(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val cep: String? = null,
    val state: String? = null,
    val country: String? = null
)
package com.gsoftware.photovoltaicsystemdesign.dto

import com.gsoftware.photovoltaicsystemdesign.entity.Address
import com.gsoftware.photovoltaicsystemdesign.entity.Phone

class CustomerForm(
    val name: String? = null,
    val cpf: String? = null,
    val email: String? = null,
    val phones: List<Phone>? = null,
    val address: Address? = null
)
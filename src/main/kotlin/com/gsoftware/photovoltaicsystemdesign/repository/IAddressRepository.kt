package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.models.entity.Address
import org.springframework.data.repository.CrudRepository

/**
 * Repository da entidade Address
 */
interface IAddressRepository: CrudRepository<Address, Long> {
}
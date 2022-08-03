package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Address
import org.springframework.data.repository.CrudRepository

/**
 * Repository da entidade Address
 */
interface IAddressRepository: CrudRepository<Address, Long> {
}
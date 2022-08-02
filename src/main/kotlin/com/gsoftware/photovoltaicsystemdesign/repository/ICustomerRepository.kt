package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import org.springframework.data.repository.CrudRepository

/**
 * Repository da entity Customer
 */
interface ICustomerRepository: CrudRepository<Customer, Long> {
}
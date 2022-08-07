package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Repository da entidade Customer
 */
interface ICustomerRepository: JpaRepository<Customer, Long> {
}
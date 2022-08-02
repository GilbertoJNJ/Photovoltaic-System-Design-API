package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import org.springframework.data.repository.CrudRepository

interface ICustomerRepository: CrudRepository<Customer, Long> {
}
package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.entity.Customer

interface ICustomerService {
    fun create(customer: Customer)
    fun listAll(): Iterable<Customer>
    fun findById(id: Long): Customer
    fun update(id: Long, customer: Customer)
    fun delete(id: Long)
}

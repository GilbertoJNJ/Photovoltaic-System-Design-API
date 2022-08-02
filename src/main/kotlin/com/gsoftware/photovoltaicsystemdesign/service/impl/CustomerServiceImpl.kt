package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.repository.ICustomerRepository
import com.gsoftware.photovoltaicsystemdesign.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(
    var customerRepository: ICustomerRepository
): ICustomerService {

    override fun create(customer: Customer) {
        customerRepository.save(customer)
    }

    override fun listAll(): Iterable<Customer> {
        return customerRepository.findAll()
    }

    override fun findById(id: Long): Customer {
        return customerRepository.findById(id).get()
    }

    override fun update(id: Long, customer: Customer) {
        val customerdb = customerRepository.findById(id)
        if(customerdb.isPresent) {
            customerRepository.save(customer)
        }
    }

    override fun delete(id: Long) {
        customerRepository.deleteById(id)
    }
}
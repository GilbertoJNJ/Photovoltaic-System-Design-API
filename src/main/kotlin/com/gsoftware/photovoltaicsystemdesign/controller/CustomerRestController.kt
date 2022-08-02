package com.gsoftware.photovoltaicsystemdesign.controller

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.service.ICustomerService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import javax.validation.Valid

/**
 * Controller para cadastro de clientes
 */
@RestController
@RequestMapping("/api/v1/customer")
class CustomerRestController(var customerService: ICustomerService) {


    @PostMapping
    fun createCustomer(@RequestBody @Valid customer: Customer): ResponseEntity<Customer> {
        customerService.create(customer)
        return created(URI.create(customer.name)).body(customer)
    }

    @GetMapping
    fun findAllCustomers(): ResponseEntity<Iterable<Customer>> {
        val customers = customerService.listAll()
        return ok().body(customers)
    }

    @GetMapping("/{id}")
    fun findCustomerById(@RequestParam id: Long): ResponseEntity<Customer>? {
        val customer = customerService.findById(id)
        return ok().body(customer)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@RequestParam id: Long, @RequestBody @Valid customer: Customer): ResponseEntity<Customer> {
        customerService.update(id,customer)
        return ok().body(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@RequestParam id: Long): ResponseEntity<Customer> {
        customerService.delete(id)
        return noContent().build()
    }
}
package com.gsoftware.photovoltaicsystemdesign.controller

import com.gsoftware.photovoltaicsystemdesign.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.form.CustomerForm
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
    fun createCustomer(@RequestBody @Valid customerForm: CustomerForm): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.create(customerForm)
        return created(URI.create(customerDTO.name!!)).body(customerDTO)
    }

    @GetMapping
    fun findAllCustomers(): ResponseEntity<List<CustomerDTO>> {
        val customersDTO = customerService.listAll()
        return ok().body(customersDTO)
    }

    @GetMapping("/{id}")
    fun findCustomerById(@RequestParam id: Long): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.findById(id)
        return ok().body(customerDTO)
    }

    @GetMapping("/cpf/{cpf}")
    fun findCustomerByCpf(@RequestParam cpf: String): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.findByCpf(cpf)
        return ok().body(customerDTO)
    }

    @PutMapping("/{id}")
    fun updateCustomer(@RequestParam id: Long, @RequestBody @Valid customerForm: CustomerForm): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.update(id,customerForm)
        return ok().body(customerDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@RequestParam id: Long): ResponseEntity<Any> {
        customerService.delete(id)
        return noContent().build()
    }
}
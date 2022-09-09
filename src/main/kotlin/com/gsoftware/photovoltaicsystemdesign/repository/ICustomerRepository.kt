package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.models.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

/**
 * Repository da entidade Customer
 */
interface ICustomerRepository: JpaRepository<Customer, Long> {

    fun findByCpf(cpf: String): Optional<Customer>
    fun findByEmail(email: String): Optional<Customer>
}
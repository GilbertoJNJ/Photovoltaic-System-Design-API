package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import org.springframework.stereotype.Service

/**
 * Interface do serviço de cadastro do cliente
 */
@Service
interface ICustomerService {
    /**
     * Cadastra cliente
     */
    fun create(customer: Customer)

    /**
     * Lista todos os clientes
     */
    fun listAll(): Iterable<Customer>

    /**
     * Busca cliente por id
     */
    fun findById(id: Long): Customer

    /**
     * Atualiza cliente
     */
    fun update(id: Long, customer: Customer)

    /**
     * Deleta cliente
     */
    fun delete(id: Long)
}

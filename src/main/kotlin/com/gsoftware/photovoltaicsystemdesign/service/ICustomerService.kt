package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.form.CustomerForm
import org.springframework.stereotype.Service

/**
 * Interface do serviço de cadastro do cliente
 */
@Service
interface ICustomerService {
    /**
     * Cadastra cliente
     */
    fun create(customerForm: CustomerForm): CustomerDTO

    /**
     * Lista todos os clientes
     */
    fun listAll(): List<CustomerDTO>

    /**
     * Busca cliente por id
     */
    fun findById(id: Long): CustomerDTO

    /**
     * Atualiza cliente
     */
    fun update(id: Long, customer: Customer): CustomerDTO

    /**
     * Deleta cliente
     */
    fun delete(id: Long)
}

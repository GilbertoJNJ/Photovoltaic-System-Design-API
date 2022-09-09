package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.models.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.models.form.CustomerForm
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
     * Busca cliente por cpf
     */
    fun findByCpf(cpf: String): CustomerDTO

    /**
     * Atualiza cliente
     */
    fun update(id: Long, customerForm: CustomerForm): CustomerDTO

    /**
     * Deleta cliente
     */
    fun delete(id: Long)
}

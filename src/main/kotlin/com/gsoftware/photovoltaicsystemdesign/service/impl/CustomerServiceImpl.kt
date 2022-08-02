package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.repository.ICustomerRepository
import com.gsoftware.photovoltaicsystemdesign.service.ICustomerService
import org.springframework.stereotype.Service

/**
 * Implementação do serviço de cadastro de clientes
 */
@Service
class CustomerServiceImpl(
    var customerRepository: ICustomerRepository
): ICustomerService {

    /**
     * Cadastra cliente
     *
     * @param customer: Dados do cliente
     */
    override fun create(customer: Customer) {
        customerRepository.save(customer)
    }

    /**
     * Lista todos os clientes
     *
     * @return Lista de todos os clientes
     */
    override fun listAll(): Iterable<Customer> {
        return customerRepository.findAll()
    }

    /**
     * Busca cliente por id
     *
     * @param id: ID do cliente
     * @return Cliente na base de dados
     */
    override fun findById(id: Long): Customer {
        return customerRepository.findById(id).get()
    }

    /**
     * Atualiza cliente
     *
     * @param id: ID do cliente
     * @param customer: Dados do cliente
     */
    override fun update(id: Long, customer: Customer) {
        val customerdb = customerRepository.findById(id)
        if(customerdb.isPresent) {
            customerRepository.save(customer)
        }
    }

    /**
     * Deleta cliente
     *
     * @param id: ID do cliente
     */
    override fun delete(id: Long) {
        customerRepository.deleteById(id)
    }
}
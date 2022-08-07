package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.form.CustomerForm
import com.gsoftware.photovoltaicsystemdesign.mapper.CustomerMapper
import com.gsoftware.photovoltaicsystemdesign.repository.ICustomerRepository
import com.gsoftware.photovoltaicsystemdesign.service.ICustomerService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Implementação do serviço de cadastro de clientes
 */
@Service
class CustomerServiceImpl(
    val customerRepository: ICustomerRepository,
    val customerMapper: CustomerMapper
): ICustomerService {

    /**
     * Cadastra cliente
     *
     * @param customerForm: Dados do cliente
     */
    override fun create(customerForm: CustomerForm): CustomerDTO {
        val customer = customerMapper.toCustomer(customerForm)
        val savedCustomer = customerRepository.save(customer)
        return customerMapper.toCustomerDTO(savedCustomer)
    }

    /**
     * Lista todos os clientes
     *
     * @return Lista de todos os clientes
     */
    override fun listAll(): List<CustomerDTO> {
        val findAll = customerRepository.findAll()
        return findAll.stream()
            .map { customer -> customerMapper.toCustomerDTO(customer) }
            .collect(Collectors.toList())
    }

    /**
     * Busca cliente por id
     *
     * @param id: ID do cliente
     * @return Cliente na base de dados
     */
    override fun findById(id: Long): CustomerDTO {
        val customer = customerRepository.findById(id).get()

        return customerMapper.toCustomerDTO(customer)
    }

    /**
     * Atualiza cliente
     *
     * @param id: ID do cliente
     * @param customer: Dados do cliente
     */
    override fun update(id: Long, customer: Customer): CustomerDTO {
        customerRepository.findById(id).get()
        val customerUpdated = customerRepository.save(customer)

        return customerMapper.toCustomerDTO(customerUpdated)
    }

    /**
     * Deleta cliente
     *
     * @param id: ID do cliente
     */
    override fun delete(id: Long) {
        val customerToDelete = customerRepository.findById(id).get()
        customerRepository.delete(customerToDelete)
    }
}
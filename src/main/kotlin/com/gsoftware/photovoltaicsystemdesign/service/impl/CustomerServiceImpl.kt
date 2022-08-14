package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.exception.CustomerAlreadyExistsException
import com.gsoftware.photovoltaicsystemdesign.exception.CustomerNotFoundException
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
     * @param customerForm Dados do cliente
     * @return Cliente na base de dados
     */
    override fun create(customerForm: CustomerForm): CustomerDTO {
        val customer = customerMapper.toCustomer(customerForm)
        verifyIfAlreadyRegistered(customer)
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
     * @param id ID do cliente
     * @return Cliente na base de dados
     */
    override fun findById(id: Long): CustomerDTO {
        val customer = customerRepository.findById(id)
            .orElseThrow { CustomerNotFoundException() }

        return customerMapper.toCustomerDTO(customer)
    }

    /**
     * Busca cliente por cpf
     *
     * @param cpf CPF do cliente
     * @return Cliente na base de dados
     */
    override fun findByCpf(cpf: String): CustomerDTO {
        val customer = customerRepository.findByCpf(cpf)
            .orElseThrow { CustomerNotFoundException() }

        return customerMapper.toCustomerDTO(customer)
    }

    /**
     * Atualiza cliente
     *
     * @param id ID do cliente
     * @param customerForm Dados do cliente
     * @return Cliente na base de dados
     */
    override fun update(id: Long, customerForm: CustomerForm): CustomerDTO {
        customerRepository.findById(id).orElseThrow { CustomerNotFoundException() }
        val customer = customerMapper.toCustomer(customerForm)
        customer.id = id
        val updatedCustomer = customerRepository.save(customer)
        return customerMapper.toCustomerDTO(updatedCustomer)
    }

    /**
     * Deleta cliente
     *
     * @param id ID do cliente
     */
    override fun delete(id: Long) {
        val customerToDelete = customerRepository.findById(id)
            .orElseThrow { CustomerNotFoundException() }
        customerRepository.delete(customerToDelete)
    }

    /**
     * Verifica se o cliente já é registrado na base de dados
     *
     * @param customer Cliente
     */
    private fun verifyIfAlreadyRegistered(customer: Customer) {
        val customercpf = customerRepository.findByCpf(customer.cpf!!)
        if (customercpf.isPresent) {
            throw CustomerAlreadyExistsException()
        }
        val customeremail = customerRepository.findByEmail(customer.email!!)
        if (customeremail.isPresent) {
            throw CustomerAlreadyExistsException()
        }
    }
}
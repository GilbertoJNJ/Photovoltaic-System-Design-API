package com.gsoftware.photovoltaicsystemdesign.service

import com.gsoftware.photovoltaicsystemdesign.models.dto.AddressDTO
import com.gsoftware.photovoltaicsystemdesign.models.form.AddressForm
import com.gsoftware.photovoltaicsystemdesign.models.nrelModel.Outputs
import org.springframework.stereotype.Service

/**
 * Serviço que lida com as regras de negócio de endereços do cliente
 */
@Service
interface IAddressService {

    /**
     * Cadastra um endereço para um cliente
     */

    fun create(cpf: String, addressForm: AddressForm): AddressDTO

    /**
     * Cadastra um endereço pelo cep
     */
    fun createByCep(cpf: String, cep: String): AddressDTO

    /**
     * Lista todos os endereços de um cliente
     */
    fun listAll(cpf: String): List<AddressDTO>

    /**
     * Busca endereço de um cliente por id
     */
    fun findById(cpf: String, id: Long): AddressDTO

    /**
     * Atualiza endereço do cliente
     */
    fun update(cpf: String, id: Long, addressForm: AddressForm): AddressDTO

    /**
     * Remove endereço do cliente
     */
    fun delete(cpf: String, id: Long)

    /**
     * Retorna índice de radiação solar
     */
    fun returnSolRadMonthly(cpf: String, id: Long): Outputs
}

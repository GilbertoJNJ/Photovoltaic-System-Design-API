package com.gsoftware.photovoltaicsystemdesign.service.impl

import com.gsoftware.photovoltaicsystemdesign.exception.AddressNotFoundException
import com.gsoftware.photovoltaicsystemdesign.models.dto.AddressDTO
import com.gsoftware.photovoltaicsystemdesign.exception.CustomerNotFoundException
import com.gsoftware.photovoltaicsystemdesign.models.entity.Address
import com.gsoftware.photovoltaicsystemdesign.models.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.models.form.AddressForm
import com.gsoftware.photovoltaicsystemdesign.models.googleMapsPlatformModel.Location
import com.gsoftware.photovoltaicsystemdesign.models.mapper.AddressMapper
import com.gsoftware.photovoltaicsystemdesign.models.nrelModel.Outputs
import com.gsoftware.photovoltaicsystemdesign.repository.IAddressRepository
import com.gsoftware.photovoltaicsystemdesign.repository.ICustomerRepository
import com.gsoftware.photovoltaicsystemdesign.service.IAddressService
import com.gsoftware.photovoltaicsystemdesign.client.IDeveloperNetworkNRELClient
import com.gsoftware.photovoltaicsystemdesign.client.IGoogleMapsPlatformClient
import com.gsoftware.photovoltaicsystemdesign.client.IViaCepClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Serviço que lida com as regras de negócio de endereços do cliente
 */
@Service
class AddressServiceImpl(
    val googleMapsPlatformService: IGoogleMapsPlatformClient,
    val developerNRELService: IDeveloperNetworkNRELClient,
    val viaCepService: IViaCepClient,
    val customerRepository: ICustomerRepository,
    val addressRepository: IAddressRepository,
    val addressMapper: AddressMapper
) : IAddressService {

    @Value("\${client.google.maps.credentials.key}")
    lateinit var googleKey: String

    @Value("\${client.nrel.key}")
    lateinit var nrelKey: String

    /**
     * Cadastra um endereço para um cliente
     * @param cpf CPF do cliente
     * @param addressForm Formulário do endereço
     * @return Endereço do cliente
     */
    override fun create(cpf: String, addressForm: AddressForm): AddressDTO {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        val address = addressMapper.toAddress(addressForm)
        return saveAddress(address, customer)
    }

    /**
     * Cadastra um endereço pelo cep
     * @param cpf CPF do cliente
     * @param cep cep do endereço
     * @return Endereço do cliente
     */
    override fun createByCep(cpf: String, cep: String): AddressDTO {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        val addressByCep = viaCepService.returnAddress(cep)
        val address = addressMapper.toAddress(addressByCep)
        return saveAddress(address, customer)
    }

    /**
     * Lista todos os endereços de um cliente
     * @param cpf CPF do cliente
     * @return Lista de endereços do cliente
     */
    override fun listAll(cpf: String): List<AddressDTO> {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        return customer.address?.stream()
            ?.map { address -> addressMapper.toAddressDTO(address) }
            ?.collect(Collectors.toList()) as List<AddressDTO>

    }

    /**
     * Busca endereço de um cliente por id
     * @param cpf CPF do cliente
     * @param id ID do endereço
     * @return Lista de endereços do cliente
     */
    override fun findById(cpf: String, id: Long): AddressDTO {
        val address = returnAddress(cpf, id)
        return addressMapper.toAddressDTO(address!!)
    }

    /**
     * Atualiza endereço do cliente
     * @param cpf CPF do cliente
     * @param id ID do endereço
     * @param addressForm Formulário do endereço
     * @return Endereço do cliente atualizado
     */
    override fun update(cpf: String, id: Long, addressForm: AddressForm): AddressDTO {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        val addressDb = customer.address?.stream()?.filter { address -> address.id == id }?.findFirst()
            ?.orElseThrow { AddressNotFoundException() }
        val address = addressMapper.toAddress(addressForm)
        address.id = addressDb?.id
        customer.address?.remove(addressDb)
        addressRepository.save(address)
        customer.address?.add(address)
        customerRepository.save(customer)
        return addressMapper.toAddressDTO(address)
    }

    /**
     * Remove endereço do cliente
     * @param cpf CPF do cliente
     * @param id ID do endereço
     */
    override fun delete(cpf: String, id: Long) {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        val address = customer.address?.stream()?.filter { address -> address.id == id }?.findFirst()
            ?.orElseThrow { AddressNotFoundException() }
        customer.address?.remove(address)
        addressRepository.delete(address!!)
    }

    /**
     * Retorna índice de radiação solar
     * @param cpf CPF do cliente
     * @param id ID do endereço
     * @return Índice de radiação de cada mês
     */
    override fun returnSolRadMonthly(cpf: String, id: Long): Outputs {
        val address = returnAddress(cpf, id)
        val location = sendRequestToGoogleMaps(address)
        return sendRequestToNREL(location)
    }

    /**
     * Método que salva o endereço no banco
     * @param address Endereço
     * @param customer Cliente
     * @return Endereço do cliente
     */
    private fun saveAddress(address: Address, customer: Customer): AddressDTO {
        val addressSaved = addressRepository.save(address)
        customer.address?.add(addressSaved)
        customerRepository.save(customer)
        return addressMapper.toAddressDTO(addressSaved)
    }

    /**
     * Método que verifica se o cliente existe e se o endereço pertence a ele
     * @param cpf CPF do cliente
     * @param id ID do endereço
     * @return Endereço
     */
    private fun returnAddress(cpf: String, id: Long): Address? {
        val customer = customerRepository.findByCpf(cpf).orElseThrow { CustomerNotFoundException() }
        return customer.address?.stream()?.filter { address -> address.id == id }?.findFirst()
            ?.orElseThrow { AddressNotFoundException() }
    }

    /**
     * Envia uma requisição ao google maps platform
     * @param address Endereço
     * @return Latitude e longitude do endereço
     */
    private fun sendRequestToGoogleMaps(address: Address?): Location {
        val formattedAddress =
            "${address?.street}, ${address?.number}, ${address?.district}, ${address?.city}, ${address?.state}"
        val model = googleMapsPlatformService.getResult(formattedAddress, "country:BR", googleKey)
        val result = model.results.stream().findAny().get()
        return result.geometry.location
    }

    /**
     * Retorna índice de radiação solar
     * @param location Latitude e longitude do endereço
     * @return Índice de radiação de cada mês
     */
    private fun sendRequestToNREL(location: Location): Outputs {
        val nrelModel = developerNRELService.returnSolRadMonthly(
            nrelKey,
            location.lat.toString(),
            location.lng.toString(),
            "0.5",
            "40",
            "8",
            "0",
            "0",
            "0"
        )
        return nrelModel.outputs
    }
}
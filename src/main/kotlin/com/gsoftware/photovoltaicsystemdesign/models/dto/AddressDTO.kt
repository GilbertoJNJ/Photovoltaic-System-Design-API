package com.gsoftware.photovoltaicsystemdesign.models.dto

/**
 * Classe DTO para exibir os dados de endereço do cliente
 *
 * @param id ID do endereço
 * @param street Rua
 * @param number Número da rua
 * @param district Bairro
 * @param city Cidade
 * @param state Estado
 * @param zipCode Cep
 * @param country País
 */
class AddressDTO(
    var id: Long? = null,
    var street: String? = null,
    var number: String? = null,
    var district: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zipCode: String? = null,
    var country: String? = null
)

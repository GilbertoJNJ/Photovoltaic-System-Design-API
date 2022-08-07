package com.gsoftware.photovoltaicsystemdesign.dto

/**
 * Classe DTO para exibir os dados de endereço do cliente
 *
 * @param id ID do endereço
 * @param street Rua
 * @param number Número da rua
 * @param district Bairro
 * @param city Cidade
 * @param state Estado
 * @param cep Cep
 * @param country País
 * @param locale Localização contendo latitude e longitude
 */
class AddressDTO(
    var id: Long? = null,
    var street: String? = null,
    var number: String? = null,
    var district: String? = null,
    var city: String? = null,
    var state: String? = null,
    var cep: String? = null,
    var country: String? = null,
    var locale: LocaleDTO? = null
)

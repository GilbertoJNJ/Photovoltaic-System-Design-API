package com.gsoftware.photovoltaicsystemdesign.form

/**
 * Formulário para cadastrar endereço
 *
 * @param street Rua
 * @param number Número da rua
 * @param district Bairro
 * @param city Cidade
 * @param state Estado
 * @param cep Cep
 * @param country País
 */
class AddressForm(
    val street: String? = null,
    val number: String? = null,
    val district: String? = null,
    val city: String? = null,
    val state: String? = null,
    val cep: String? = null,
    val country: String? = null
)


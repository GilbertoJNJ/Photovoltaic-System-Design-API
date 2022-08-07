package com.gsoftware.photovoltaicsystemdesign.dto

/**
 * Classe DTO para exibir os dados do cliente
 *
 * @param id ID do cliete
 * @param name Nome do cliente
 * @param cpf CPF do cliente
 * @param email E-mail do cliente
 * @param phones Lista de telefones do cliente
 * @param address Lista de endereços do cliente
 * @param status Identifica se o cliente está ativo
 */
class CustomerDTO(
    var id: Long? = null,
    var name: String? = null,
    var cpf: String? = null,
    var email: String? = null,
    var phones: List<PhoneDTO>? = null,
    var address: List<AddressDTO>? = null,
    var status: Status? = null
) {
    enum class Status {
        ACTIVE,
        INACTIVE
    }
}
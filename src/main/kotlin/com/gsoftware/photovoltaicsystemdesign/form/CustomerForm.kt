package com.gsoftware.photovoltaicsystemdesign.form

/**
 * Formulário para cadastrar os dados do cliente
 *
 * @param name Nome do cliente
 * @param cpf CPF do cliente
 * @param email E-mail do cliente
 * @param phones Lista de telefones do cliente
 * @param address Lista de endereços do cliente
 * @param status Identifica se o cliente está ativo
 */
class CustomerForm(
    val name: String? = null,
    val cpf: String? = null,
    val email: String? = null,
    val phones: List<PhoneForm>? = null,
    val address: List<AddressForm>? = null,
    val status: Status? = null
) {
    enum class Status {
        ACTIVE,
        INACTIVE
    }
}
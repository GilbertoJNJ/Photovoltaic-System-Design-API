package com.gsoftware.photovoltaicsystemdesign.form

import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

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

    @field:NotBlank
    val name: String,

    @field:CPF
    @field:NotBlank
    val cpf: String,

    @field:Email
    @field:NotBlank
    val email: String,

    val phones: List<PhoneForm>? = null,

    val address: List<AddressForm>? = null,

    val status: Status? = null

) {
    enum class Status {
        ACTIVE,
        INACTIVE
    }
}
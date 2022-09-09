package com.gsoftware.photovoltaicsystemdesign.models.form

/**
 * Formulário para cadastrar o telefone de contato do cliente
 *
 * @param ddd DDD da região
 * @param number Número de telefone
 */
class PhoneForm(
    val ddd: String? = null,
    val number: String? = null
)

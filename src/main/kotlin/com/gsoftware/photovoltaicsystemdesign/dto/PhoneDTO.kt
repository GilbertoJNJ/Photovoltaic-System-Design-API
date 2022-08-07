package com.gsoftware.photovoltaicsystemdesign.dto

/**
 * Classe DTO que exibe o telefone de contato do cliente
 *
 * @param id ID do telefone
 * @param ddd DDD da região
 * @param number Número de telefone
 */
class PhoneDTO(
    var id: Long? = null,
    var ddd: String? = null,
    var number: String? = null
)

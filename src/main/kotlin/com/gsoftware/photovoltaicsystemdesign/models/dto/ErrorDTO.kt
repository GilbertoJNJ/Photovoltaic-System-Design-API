package com.gsoftware.photovoltaicsystemdesign.models.dto

/**
 * Modelo de dados para respostas de erro.
 * @param code código de erro
 * @param message mensagem do erro
 */
data class ErrorDTO(
  var code: Int? = null,
  var message: String? = null,
)

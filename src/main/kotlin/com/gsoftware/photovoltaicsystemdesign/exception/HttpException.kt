package com.gsoftware.photovoltaicsystemdesign.exception

import org.springframework.http.HttpStatus

/**
 * Exceção genérica lançada pela aplicação
 * @param code Status da requisição
 * @param message Mensagem a ser enviada na requisição
 */
open class HttpException(
    val code: HttpStatus,
    override val message: String
) : Exception()
package com.gsoftware.photovoltaicsystemdesign.exception

import com.gsoftware.photovoltaicsystemdesign.messages.Messages.Error.CUSTOMER_NOT_FOUND
import org.springframework.http.HttpStatus

/**
 * Exceção a ser lançada quando um cliente não for encontrado na base de dados.
 */
class CustomerNotFoundException(): HttpException(HttpStatus.NOT_FOUND, CUSTOMER_NOT_FOUND)
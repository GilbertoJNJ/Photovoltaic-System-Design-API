package com.gsoftware.photovoltaicsystemdesign.exception

import com.gsoftware.photovoltaicsystemdesign.models.messages.Messages.Error.CUSTOMER_ALREADY_EXISTS
import org.springframework.http.HttpStatus

/**
 * Exceção a ser lançada quando um cliente já estiver sido registrado na base de dados.
 */
class CustomerAlreadyExistsException(): HttpException(HttpStatus.BAD_REQUEST, CUSTOMER_ALREADY_EXISTS)
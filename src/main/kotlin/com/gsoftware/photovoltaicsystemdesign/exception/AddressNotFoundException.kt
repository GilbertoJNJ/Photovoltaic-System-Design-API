package com.gsoftware.photovoltaicsystemdesign.exception

import com.gsoftware.photovoltaicsystemdesign.models.messages.Messages
import org.springframework.http.HttpStatus

/**
 * Exceção a ser lançada quando um endereço não for encontrado na base de dados.
 */
class AddressNotFoundException(): HttpException(HttpStatus.NOT_FOUND, Messages.Error.ADDRESS_NOT_FOUND)
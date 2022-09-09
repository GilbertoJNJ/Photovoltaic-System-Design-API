package com.gsoftware.photovoltaicsystemdesign.exception.handler

import com.fasterxml.jackson.databind.JsonMappingException
import com.gsoftware.photovoltaicsystemdesign.models.dto.ErrorDTO
import com.gsoftware.photovoltaicsystemdesign.exception.HttpException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/**
 * Handler que lida com as exceções da aplicação para que sejam enviadas respostas explicitando o que
 * ocasionou o erro na requisição
 */
@RestControllerAdvice
class HttpResponseHandler : ResponseEntityExceptionHandler() {

    /**
     * Handler de exceções do tipo HttpException
     */
    @ExceptionHandler(HttpException::class)
    fun handleHttpException(e: HttpException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.status(e.code).body(ErrorDTO(e.code.value(), e.message))
    }

    /**
     * Handler que lida com as mensagens de erro no formulário das requisições
     * que são recebidas pela API.
     */
    @ExceptionHandler(JsonMappingException::class)
    fun handleParamsException(e: JsonMappingException, request: WebRequest): ResponseEntity<Any> {
        return ResponseEntity.badRequest().body(ErrorDTO(HttpStatus.BAD_REQUEST.value(), e.localizedMessage))
    }

    /**
     * Sobrescrita do handler de validação de campos para que as mensagens fiquem no padrão correto.
     */
    override fun handleMethodArgumentNotValid(
        e: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {

        val errorBuilder = StringBuilder()
        e.bindingResult.allErrors.forEach { error ->
            errorBuilder.append(" ${(error as FieldError).field} ${error.defaultMessage}, ")
        }

        val message = "Validation failed for argument [${e.parameter.parameter.name}]: $errorBuilder"
        return ResponseEntity.badRequest().body(ErrorDTO(HttpStatus.BAD_REQUEST.value(), message))
    }
}
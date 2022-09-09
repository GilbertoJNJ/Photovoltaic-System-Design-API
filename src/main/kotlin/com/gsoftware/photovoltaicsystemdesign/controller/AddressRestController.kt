package com.gsoftware.photovoltaicsystemdesign.controller

import com.gsoftware.photovoltaicsystemdesign.models.dto.AddressDTO
import com.gsoftware.photovoltaicsystemdesign.models.form.AddressForm
import com.gsoftware.photovoltaicsystemdesign.models.nrelModel.Outputs
import com.gsoftware.photovoltaicsystemdesign.service.IAddressService
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.http.ResponseEntity.noContent
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import java.net.URI
import javax.validation.Valid

/**
 * Controller que gerencia endereços
 */
@RestController
@RequestMapping("/api/v1/address/customer")
class AddressRestController(var addressService: IAddressService) {

    @PostMapping("/{cpf}")
    fun create(@PathVariable cpf: String, @RequestBody @Valid addressForm: AddressForm): ResponseEntity<AddressDTO> {
        val addressDTO = addressService.create(cpf, addressForm)
        return created(URI.create("")).body(addressDTO)
    }

    @PostMapping("/{cpf}/cep")
    fun createByCep(@PathVariable cpf: String, @RequestParam(name = "cep") cep: String): ResponseEntity<AddressDTO> {
        val addressDTO = addressService.createByCep(cpf, cep)
        return ok().body(addressDTO)
    }

    @GetMapping("/{cpf}")
    fun listAll(@PathVariable cpf: String): ResponseEntity<List<AddressDTO>> {
        val addressDTO = addressService.listAll(cpf)
        return ok().body(addressDTO)
    }

    @GetMapping("/{cpf}/{id}")
    fun findById(@PathVariable cpf: String, @PathVariable id: Long): ResponseEntity<AddressDTO> {
        val addressDTO = addressService.findById(cpf, id)
        return ok().body(addressDTO)
    }

    @PutMapping("/{cpf}/{id}")
    fun update(@PathVariable cpf: String, @PathVariable id: Long, @RequestBody addressForm: AddressForm): ResponseEntity<AddressDTO> {
        val addressDTO = addressService.update(cpf, id, addressForm)
        return ok().body(addressDTO)
    }

    @DeleteMapping("/{cpf}/{id}")
    fun delete(@PathVariable cpf: String, @PathVariable id: Long): ResponseEntity<Any> {
        addressService.delete(cpf, id)
        return noContent().build()
    }

    @PatchMapping("/{cpf}/{id}")
    fun returnSolRadMonthly(@PathVariable cpf: String, @PathVariable id: Long): ResponseEntity<Outputs> {
        val location = addressService.returnSolRadMonthly(cpf, id)
        return ok().body(location)
    }
}
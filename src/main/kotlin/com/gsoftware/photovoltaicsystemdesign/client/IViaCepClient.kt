package com.gsoftware.photovoltaicsystemdesign.client

import com.gsoftware.photovoltaicsystemdesign.models.viaCepModel.ViaCepModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * Client do viaCep
 */
@FeignClient(name = "viacep", url = "\${client.viacep.url}")
interface IViaCepClient {

    @GetMapping("/{cep}/json/")
    fun returnAddress(@PathVariable cep: String): ViaCepModel
}
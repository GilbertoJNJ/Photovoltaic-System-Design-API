package com.gsoftware.photovoltaicsystemdesign.service

import org.springframework.cloud.openfeign.FeignClient

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
interface IViaCepService {
}
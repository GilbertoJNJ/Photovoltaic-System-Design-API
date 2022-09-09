package com.gsoftware.photovoltaicsystemdesign.client

import com.gsoftware.photovoltaicsystemdesign.models.nrelModel.NRELModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

/**
 * Client do Developer Network NREL
 */
@FeignClient(name = "developerNetworkNREL", url = "\${client.nrel.url}")
interface IDeveloperNetworkNRELClient {

    @GetMapping("/v6.json")
    fun returnSolRadMonthly(@RequestParam(name = "api_key") apiKey: String,
                            @RequestParam(name = "lat") lat: String,
                            @RequestParam(name = "lon") lon: String,
                            @RequestParam(name = "system_capacity") systemCapacity: String,
                            @RequestParam(name = "azimuth") azimuth: String,
                            @RequestParam(name = "tilt") tilt: String,
                            @RequestParam(name = "array_type") arrayType: String,
                            @RequestParam(name = "module_type") moduleType: String,
                            @RequestParam(name = "losses") losses: String): NRELModel
}
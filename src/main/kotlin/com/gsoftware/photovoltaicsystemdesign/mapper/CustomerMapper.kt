package com.gsoftware.photovoltaicsystemdesign.models.mapper

import com.gsoftware.photovoltaicsystemdesign.models.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.models.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.models.form.CustomerForm
import org.mapstruct.Mapper

/**
 * Mapeamento de dados do cliente
 */
@Mapper
interface CustomerMapper {

    fun toCustomerDTO(customer: Customer): CustomerDTO

    fun toCustomer(customerForm: CustomerForm): Customer

}
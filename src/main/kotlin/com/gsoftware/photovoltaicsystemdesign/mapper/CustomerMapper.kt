package com.gsoftware.photovoltaicsystemdesign.mapper

import com.gsoftware.photovoltaicsystemdesign.dto.CustomerDTO
import com.gsoftware.photovoltaicsystemdesign.entity.Customer
import com.gsoftware.photovoltaicsystemdesign.form.CustomerForm
import org.mapstruct.Mapper

/**
 * Mapeamento de dados do cliente
 */
@Mapper
interface CustomerMapper {

    fun toCustomerDTO(customer: Customer): CustomerDTO

    fun toCustomer(customerForm: CustomerForm): Customer

}
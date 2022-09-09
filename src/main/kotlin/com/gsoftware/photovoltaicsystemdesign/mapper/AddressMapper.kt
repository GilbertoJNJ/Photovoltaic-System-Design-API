package com.gsoftware.photovoltaicsystemdesign.models.mapper

import com.gsoftware.photovoltaicsystemdesign.models.dto.AddressDTO
import com.gsoftware.photovoltaicsystemdesign.models.entity.Address
import com.gsoftware.photovoltaicsystemdesign.models.form.AddressForm
import com.gsoftware.photovoltaicsystemdesign.models.viaCepModel.ViaCepModel
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

/**
 * Mapeamento de endereços do cliente
 */
@Mapper
interface AddressMapper {

    fun toAddressDTO(address: Address): AddressDTO

    fun toAddress(addressForm: AddressForm): Address

    @Mappings(
        Mapping(target = "zipCode", source = "viaCepModel.cep"),
        Mapping(target = "street", source = "viaCepModel.logradouro"),
        Mapping(target = "district", source = "viaCepModel.bairro"),
        Mapping(target = "city", source = "viaCepModel.localidade"),
        Mapping(target = "state", source = "viaCepModel.uf")
    )
    fun toAddress(viaCepModel: ViaCepModel): Address

}
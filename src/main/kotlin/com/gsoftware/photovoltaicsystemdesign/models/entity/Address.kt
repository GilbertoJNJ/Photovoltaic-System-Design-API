package com.gsoftware.photovoltaicsystemdesign.models.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.FetchType
import javax.persistence.CascadeType

/**
 * Entidade que representa o endereço do cliente
 *
 * @param id ID do endereço
 * @param street Rua
 * @param number Número da rua
 * @param district Bairro
 * @param city Cidade
 * @param state Estado
 * @param zipCode Cep
 * @param country País
 */
@Entity
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var street: String? = null,

    @Column
    var number: String? = null,

    @Column
    var district: String? = null,

    @Column
    var city: String? = null,

    @Column
    var state: String? = null,

    @Column
    var zipCode: String? = null,

    @Column
    var country: String? = null
)
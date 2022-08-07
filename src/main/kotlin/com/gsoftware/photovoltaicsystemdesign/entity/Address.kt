package com.gsoftware.photovoltaicsystemdesign.entity

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
 * @param cep Cep
 * @param country País
 * @param locale Localização contendo latitude e longitude
 */
@Entity
class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

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
    var cep: String? = null,

    @Column
    var country: String? = null,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val locale: Locale? = null
)
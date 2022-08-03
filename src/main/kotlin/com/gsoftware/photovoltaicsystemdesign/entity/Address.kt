package com.gsoftware.photovoltaicsystemdesign.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

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
    val id: Long,

    @Column
    @NotNull
    val street: String,

    @Column
    val number: String? = null,

    @Column
    val district: String? = null,

    @Column
    @NotNull
    val city: String,

    @Column
    @NotNull
    val state: String,

    @Column
    val cep: String? = null,

    @Column
    @NotNull
    val country: String,

    @OneToOne
    val locale: Locale? = null
)
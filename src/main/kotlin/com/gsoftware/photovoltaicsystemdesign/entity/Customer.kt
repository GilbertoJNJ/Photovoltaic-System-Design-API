package com.gsoftware.photovoltaicsystemdesign.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Enumerated
import javax.persistence.EnumType
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType

/**
 * Entidade que representa o cliente
 *
 * @param id ID do cliete
 * @param name Nome do cliente
 * @param cpf CPF do cliente
 * @param email E-mail do cliente
 * @param phones Lista de telefones do cliente
 * @param address Lista de endereços do cliente
 * @param status Identifica se o cliente está ativo
 */
@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var name: String? = null,

    @Column
    var cpf: String? = null,

    @Column
    var email: String? = null,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var phones: List<Phone>? = null,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var address: List<Address>? = null,

    @Column
    @Enumerated(EnumType.ORDINAL)
    var status: Status? = null,
) {
    enum class Status {
        ACTIVE,
        INACTIVE
    }
}
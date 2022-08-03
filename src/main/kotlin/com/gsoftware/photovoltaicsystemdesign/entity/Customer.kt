package com.gsoftware.photovoltaicsystemdesign.entity

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Enumerated
import javax.persistence.EnumType
import javax.persistence.OneToMany
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

/**
 * Entidade que representa o cliente
 *
 * @param id ID do cliete
 * @param name Nome do cliente
 * @param cpf CPF do cliente
 * @param email E-mail do cliente
 * @param status Identifica se o cliente está ativo
 */
@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column
    @NotNull
    val name: String,

    @Column
    @CPF
    val cpf: String,

    @Column
    @Email
    val email: String,

    @OneToMany
    val phone: List<Phone>? = null,

    @ManyToMany
    val address: List<Address>? = null,

    @Column
    @Enumerated(EnumType.ORDINAL)
    var status: Status? = null,
) {
    enum class Status {
        ACTIVE,
        INACTIVE
    }
}
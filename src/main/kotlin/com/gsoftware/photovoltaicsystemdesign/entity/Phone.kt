package com.gsoftware.photovoltaicsystemdesign.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Entidade que representa o telefone de contato do cliente
 *
 * @param id ID do telefone
 * @param ddd DDD da região
 * @param number Número de telefone
 */
@Entity
class Phone(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val ddd: String? = null,

    @Column
    val number: String? = null
)

package com.gsoftware.photovoltaicsystemdesign.models.entity

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
    var id: Long? = null,

    @Column
    var ddd: String? = null,

    @Column
    var number: String? = null
)

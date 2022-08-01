package com.gsoftware.photovoltaicsystemdesign.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.Email

@Entity
class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val name: String? = null,

    @Column
    val cpf: String? = null,

    @Column
    val email: String? = null,

    @OneToMany
    val phones: List<Phone>? = null,

    @ManyToOne
    val address: Address? = null,

    @Column
    val isActive: Boolean? = null
)
package com.gsoftware.photovoltaicsystemdesign.entity

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

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

    @Column
    val isActive: Boolean? = false,
)
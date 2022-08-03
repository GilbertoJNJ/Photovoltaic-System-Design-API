package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Phone
import org.springframework.data.repository.CrudRepository

/**
 * Repository da entidade Phone
 */
interface IPhoneRepository: CrudRepository<Phone, Long> {
}
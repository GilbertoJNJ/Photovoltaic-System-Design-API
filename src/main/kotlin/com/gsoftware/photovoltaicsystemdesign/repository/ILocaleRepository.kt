package com.gsoftware.photovoltaicsystemdesign.repository

import com.gsoftware.photovoltaicsystemdesign.entity.Locale
import org.springframework.data.repository.CrudRepository

/**
 * Repository da entidade Locale
 */
interface ILocaleRepository: CrudRepository<Locale, Long> {
}
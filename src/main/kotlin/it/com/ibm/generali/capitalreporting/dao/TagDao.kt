package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Tag
import org.springframework.data.repository.CrudRepository

interface TagDao : CrudRepository<Tag, Long>

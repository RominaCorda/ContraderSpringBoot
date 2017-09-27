package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.Template
import org.springframework.data.repository.CrudRepository

interface TemplateDao : CrudRepository<Template, Long>
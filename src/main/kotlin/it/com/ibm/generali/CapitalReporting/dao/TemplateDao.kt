package it.com.ibm.generali.CapitalReporting.dao

import it.com.ibm.generali.CapitalReporting.model.Template
import org.springframework.data.repository.CrudRepository

interface TemplateDao : CrudRepository<Template, Long>

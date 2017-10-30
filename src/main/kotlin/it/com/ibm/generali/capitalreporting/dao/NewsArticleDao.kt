package it.com.ibm.generali.capitalreporting.dao

import it.com.ibm.generali.capitalreporting.model.NewsArticle
import org.springframework.data.repository.CrudRepository

interface NewsArticleDao : CrudRepository<NewsArticle, Long>
{
    fun findByPublished(published: Boolean): List<NewsArticle>
    fun findTop2ByPublishedIsTrueOrderByCreated(): List<NewsArticle>
}


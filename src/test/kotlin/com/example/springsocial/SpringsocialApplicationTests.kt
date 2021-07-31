package com.example.springsocial

import com.example.springsocial.api.author.Author
import com.example.springsocial.api.book.Book
import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.client.RestTemplate
import javax.persistence.EntityManager
import javax.persistence.Query


@Slf4j
@SpringBootTest
class SpringsocialApplicationTests {

	@Autowired
	var em: EntityManager? = null

//	@Autowired
//	var resTemplate: RestTemplate? = null

	private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
	@Test
	fun queryWhere() {
		val query: Query = em!!.createQuery("select a from Author a WHERE  a.name LIKE '%thanh%'") //<-注意這邊

		val resultlist: List<Author> = query.resultList as List<Author>
		logger.info("jpql_basic:select c from Course c ->{}", resultlist)
	}

}

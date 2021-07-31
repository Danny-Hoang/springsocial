package com.example.springsocial.api.author

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Service
public class AuthorService {
    @Autowired
    lateinit var entityManager: EntityManager

    @Transactional
    public fun getAll(): List<AuthorDto> {
        return entityManager.createNativeQuery("""
                                    SELECT a.author_id, a.author_name, a.author_bio FROM authors a
                                """, Author::class.java).getResultList().toList() as List<AuthorDto>
    }
}

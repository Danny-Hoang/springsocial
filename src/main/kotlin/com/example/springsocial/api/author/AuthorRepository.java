package com.example.springsocial.api.author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(
            value = """
            select a from Author a WHERE  a.name LIKE %:authorName%
        """
    )

    Page<Author> findAuthorNameLike(@Param("authorName") String authorName, Pageable pageable);
}

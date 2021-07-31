package com.example.springsocial.api.book

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional


@Repository
@Transactional
interface BookRepository: JpaRepository<Book, Long> {

//    @EntityGraph(
//        type = EntityGraph.EntityGraphType.FETCH,
//        attributePaths = [
//            "categories",
//            "authors"
//        ]
//    )
//    override fun findById(id: Long): Optional<Book>


//    @EntityGraph(type = EntityGraphType.FETCH, attributePaths = ["categories"])
//    override fun findById(id: Long): Optional<Book>

//    @Query(
//        value = """
//            SELECT  b.title, b.publisher_id FROM books b  WHERE b.title LIKE '%Nam%'
//        """,
//        nativeQuery = true,
//        countQuery = """
//            SELECT count(*) FROM books WHERE title LIKE '%Nam%'
//        """
//    )
//    fun findBooksWithCategories(): BookDto



    @Query(
        value = """
            SELECT b.title, b.code, b.categories, b.publisher, b.authors, b.price, b.publishYear FROM  Book b 
            LEFT JOIN FETCH b.categories
            LEFT JOIN FETCH b.authors
            LEFT JOIN FETCH b.publisher
            WHERE b.id = 100004
        """
    )
    fun getBooksDto2(): List<Book>

        @Query(
        value = """
                SELECT b.id as bookId, b.title as bookTitle, p as publisher, a as authors,  c as categories FROM Book b
                LEFT JOIN b.categories c
                LEFT JOIN b.authors a
                LEFT JOIN b.publisher p
                    
                WHERE b.id = 100004
            """
    )
        fun getBooksDto(): List<DataDto>

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Book b SET b.title = ?1, b.description=?2 WHERE b.id = ?3")
    fun setBookInfoById( bookTitle: String, description : String, bookId: Long): Long;
}
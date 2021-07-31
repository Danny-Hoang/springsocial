package com.example.springsocial.api.bookauthor

import com.example.springsocial.api.book.Book
import com.example.springsocial.api.category.Category
import javax.persistence.*

@Entity
@Table(name = "book_author")
data class BookAuthor (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bookAuthorId: Long = 0,

    @ManyToOne
    var book: Book = Book(),

    @ManyToOne
    var author: BookAuthor,
)

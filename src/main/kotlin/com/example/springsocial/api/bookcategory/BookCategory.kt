package com.example.springsocial.api.bookcategory

import com.example.springsocial.api.book.Book
import com.example.springsocial.api.category.Category
import javax.persistence.*

@Entity
@Table(name = "book_category")
data class BookCategory (

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bookCategoryId: Long = 0,

    @ManyToOne
    var book: Book = Book(),

    @ManyToOne
    var category: Category = Category(),

)

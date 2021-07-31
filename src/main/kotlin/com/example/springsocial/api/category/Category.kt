package com.example.springsocial.api.category

import com.example.springsocial.api.bookcategory.BookCategory
import javax.persistence.*

@Entity
@Table(name = "categories")
data class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    val id: Int = 0,

    val name: String = "",
    val code: String = "",


//    @ManyToMany(mappedBy="categories", fetch = FetchType.LAZY)
//    @JsonIgnore
//    var books: Set<Book> = mutableSetOf()

//    @OneToMany
//    var bookCategoryList: List<BookCategory> = mutableListOf<BookCategory>()
)
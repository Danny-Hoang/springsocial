package com.example.springsocial.api.publisher

import com.example.springsocial.api.book.Book
import javax.persistence.*

@Entity
@Table(name = "publishers")
data class Publisher (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String = "",
    val info: String = "",

//    @OneToMany(mappedBy="publisher", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
//    val books: Set<Book> = mutableSetOf<Book>()
)
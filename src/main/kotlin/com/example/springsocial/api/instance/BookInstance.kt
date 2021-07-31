package com.example.springsocial.api.instance

import com.example.springsocial.api.book.Book
import javax.persistence.*

@Entity
@Table(name = "book_instances")
data class BookInstance (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="instance_id", nullable = false)
    val id: Long,

    @ManyToOne
    var Book: Book = Book(),

//    @OneToMany(mappedBy="publisher", cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
//    val books: Set<Book> = mutableSetOf<Book>()
)


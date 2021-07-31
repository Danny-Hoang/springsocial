package com.example.springsocial.api.author

import com.example.springsocial.api.book.Book
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import lombok.EqualsAndHashCode
import lombok.ToString
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "authors")
data class Author (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    val name: String = "",
    val bio: String? = ""

//    @ManyToMany(mappedBy="authors", fetch = FetchType.LAZY)
//    @JsonIgnore
//    var books: Set<Book> = mutableSetOf()
)
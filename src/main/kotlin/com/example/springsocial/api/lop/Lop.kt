package com.example.springsocial.api.lop

import com.example.springsocial.api.book.Book
import com.example.springsocial.api.reader.Reader
import javax.persistence.*

@Entity
@Table(name = "lops")
data class Lop (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="lop_id", nullable = false)
    val id: Int = 0,

    val name: String = "",
)

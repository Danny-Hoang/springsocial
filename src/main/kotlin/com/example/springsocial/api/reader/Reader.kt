package com.example.springsocial.api.reader

import com.example.springsocial.api.lop.Lop

import com.example.springsocial.api.author.Author
import com.example.springsocial.api.category.Category
import com.fasterxml.jackson.annotation.*
import lombok.EqualsAndHashCode
import lombok.ToString
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "readers")
data class Reader (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val readerId: Long = 0,

    val name: String = "",
    val email: String = "",
    val avatar: String = "",
    val phone: String = "",
    val parentPhone: String = "",
    val active: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var lop: Lop = Lop(),

)

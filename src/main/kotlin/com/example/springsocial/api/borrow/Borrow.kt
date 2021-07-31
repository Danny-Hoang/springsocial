package com.example.springsocial.api.borrow

import com.example.springsocial.api.author.Author
import com.example.springsocial.api.category.Category
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Borrow (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val borrowId: Int = 0,

    val instanceId: Int = 0,

)


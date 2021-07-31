package com.example.springsocial.api.book

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.math.BigInteger
import java.time.LocalDateTime
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;


data class BookDto(
    var title: String,
    var bookID: BigInteger,
    var categories: String
    )


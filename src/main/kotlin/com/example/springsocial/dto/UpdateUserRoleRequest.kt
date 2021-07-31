package com.example.springsocial.dto

data class UpdateUserRoleRequest(
    val userID: Long = 0,
    val roles: Set<String> = setOf()
)

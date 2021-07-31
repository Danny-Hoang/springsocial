package com.example.springsocial.api.user


data class UserDto(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val isAdmin: Boolean,
    val email: String
) {
    companion object {
        fun fromUser(user: User, isAdmin: Boolean): UserDto {
            return UserDto(
                id = user.id,
                name = user.name,
                imageUrl = user.imageUrl,
                email = user.email,
                isAdmin = isAdmin
            )
        }
    }
}

package com.example.springsocial.api.user

import com.example.springsocial.api.user.UserDto.Companion.fromUser
import com.example.springsocial.exception.ResourceNotFoundException
import com.example.springsocial.repository.UserRepository
import com.example.springsocial.security.CurrentUser
import com.example.springsocial.security.UserPrincipal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {
    @Autowired
    private val userRepository: UserRepository? = null

    @GetMapping("/me") //    @PreAuthorize("hasRole('USER')")
    fun getCurrentUser(@CurrentUser userPrincipal: UserPrincipal): UserDto {
        val user = userRepository!!.findById(userPrincipal.id)
            .orElseThrow {
                ResourceNotFoundException(
                    "User",
                    "id",
                    userPrincipal.id
                )
            }
        val listGrantedAuthority =
            userPrincipal.authorities as List<SimpleGrantedAuthority>
        val roles =
            listGrantedAuthority.stream().map { r: SimpleGrantedAuthority -> r.authority }.toList()
        val isAdmin = roles.stream().anyMatch { s: String -> s == "ROLE_ADMIN" }
        return fromUser(user, isAdmin)
    }

    fun setAdmin() {}
}
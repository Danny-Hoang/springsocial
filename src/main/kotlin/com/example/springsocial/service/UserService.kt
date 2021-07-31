package com.example.springsocial.service

import com.example.springsocial.dto.UpdateUserRoleRequest
import com.example.springsocial.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private  val userRepository: UserRepository) {
//    fun updateUserRole(payload: UpdateUserRoleRequest): Any {
//        val user = userRepository.getById(payload.userID)
//
//    }
}
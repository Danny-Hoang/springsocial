package com.example.springsocial.api.role;

import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.api.user.User;
import com.example.springsocial.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void initDefaultRoles() {
        this.roleRepository.clearRoles();
        this.roleRepository.initDefaultRoles();

//        Role adminRole = this.roleRepository.getById(1);
////        Role userRole = this.roleRepository.getById(2);
//        User u = this.userRepository.getById(1L);
//        if(u != null) {
////            u.setRoles(Collections.singleton(roleAdmin));
////            this.userRepository.save(u);
//            this.setAdmin(1L);
//        } else {
//            User admin = new User();
//            admin.setId(1L);
//            admin.setEmail("hoangthai0302@gmail.com");
//            admin.setName("hoang thai");
//            admin.setPassword("123456");
//            admin.setRoles(Collections.singleton(adminRole));
//            this.userRepository.save(u);
//        }

    }


    @Transactional
    public Role createRole(String name) {
        return this.roleRepository.save(new Role(name));
    }

    @Transactional
    public Role setAdmin(Long userID) {
        Role adminRole = this.roleRepository.getById(1);
        User u = this.userRepository.getById(userID);
        if(u == null || adminRole == null) {

            throw new ResourceNotFoundException("user", "id", userID);
        }

        u.setRoles(Collections.singleton(adminRole));
        this.userRepository.save(u);
        return adminRole;
    }
}

package com.example.springsocial.api.role;

import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.annotation.security.RolesAllowed;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    public RoleController(RoleService roleService, UserRepository userRepository, RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    private final RoleService roleService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @PutMapping("/admin/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Role setAdmin(@PathVariable Long id) {
        return roleService.setAdmin(id);
    }

}

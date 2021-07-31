package com.example.springsocial;

import com.example.springsocial.api.role.RoleName;
import com.example.springsocial.api.role.RoleService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DatabaseInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final RoleService roleService;
    public  DatabaseInitializer(RoleService roleService) {
        this.roleService = roleService;
    }
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        roleService.initDefaultRoles();
    }

}

package com.example.springsocial.api.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserWithRole {
    private User user;
//    private List<String> roles;
}

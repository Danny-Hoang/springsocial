package com.example.springsocial.api.role;

import com.example.springsocial.api.role.Role;
import com.example.springsocial.api.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleName);

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "DELETE FROM roles WHERE 1", nativeQuery = true)
    void clearRoles();

    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "INSERT INTO roles(id, name) VALUES(1, 'ROLE_ADMIN'),(2,'ROLE_USER')", nativeQuery = true)
    void initDefaultRoles();

//    @Modifying(flushAutomatically = true)
//    @Query(value = "DELETE FROM users WHERE id = 1", nativeQuery = true)
//    void clearRootUser();
//
//    @Modifying(flushAutomatically = true)
//    @Query(value = "INSERT INTO users(id, email, name) WHERE id = 1", nativeQuery = true)
//    void insertRootUser();
}

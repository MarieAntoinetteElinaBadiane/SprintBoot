package com.devweb.RH.repository;

import com.devweb.RH.model.Role;
import com.devweb.RH.model.RoleNom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(RoleNom roleNom);
}

package com.korfax.simple_hibernate.repositories;

import com.korfax.simple_hibernate.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findByName(String name);

}

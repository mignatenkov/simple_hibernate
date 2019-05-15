package com.korfax.simple_hibernate.repositories;

import com.korfax.simple_hibernate.entities.Role;
import com.korfax.simple_hibernate.entities.User;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Cacheable ("ehcache")
    List<Role> findByName(String name);

    @Cacheable("ehcache")
    @CacheEvict (value = "ehcache", allEntries = true)
    List<Role> findAll();

}

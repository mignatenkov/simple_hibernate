package com.korfax.simple_hibernate.workers;

import com.korfax.simple_hibernate.entities.Role;
import com.korfax.simple_hibernate.entities.User;
import com.korfax.simple_hibernate.entities.UserInfo;
import com.korfax.simple_hibernate.repositories.RoleRepository;
import com.korfax.simple_hibernate.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Worker {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public void doWork() {
        Role newRole = new Role("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(newRole);

        User newUser = new User("user1");
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("qwe");
        userInfo.setLastName("qwe");
        userInfo.setAddress("qwe");
        newUser.setUserInfo(userInfo);

        newUser.setRoles(roles);
        newUser.getRoles().stream().forEach(role -> {
            List<User> users = new ArrayList<>();
            users.add(newUser);
            role.setUsers(users);
        });

        userRepository.save(newUser);

        Role reseivedRole = roleRepository.findByName("ROLE_USER").get(0);
        System.out.println(reseivedRole.toString());
        System.out.println(Arrays.deepToString(reseivedRole.getUsers().toArray()));
    }

}
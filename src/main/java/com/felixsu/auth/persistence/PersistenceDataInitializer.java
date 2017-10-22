package com.felixsu.auth.persistence;

import com.felixsu.auth.persistence.dao.PrivilegeRepository;
import com.felixsu.auth.persistence.dao.UserRepository;
import com.felixsu.auth.persistence.model.Privilege;
import com.felixsu.auth.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created on 10/22/17.
 *
 * @author felixsoewito
 */
@Component
public class PersistenceDataInitializer {

    private UserRepository userRepository;
    private PrivilegeRepository privilegeRepository;
    private PasswordEncoder encoder;

    @Autowired
    public PersistenceDataInitializer(UserRepository userRepository, PrivilegeRepository privilegeRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.privilegeRepository = privilegeRepository;
        this.encoder = encoder;
    }

    @PostConstruct
    public void init() {
        initPrivileges();
        initUsers();
    }

    private void initPrivileges() {
        if (privilegeRepository.findByName("READ_PRIVILEGE") == null) {
            final Privilege privilege1 = new Privilege("READ_PRIVILEGE");
            privilegeRepository.save(privilege1);
        }

        if (privilegeRepository.findByName("WRITE_PRIVILEGE") == null) {
            final Privilege privilege2 = new Privilege("WRITE_PRIVILEGE");
            privilegeRepository.save(privilege2);
        }
    }

    private void initUsers() {
        final Privilege privilege1 = privilegeRepository.findByName("READ_PRIVILEGE");
        final Privilege privilege2 = privilegeRepository.findByName("WRITE_PRIVILEGE");

        if (userRepository.findByUsername("john") == null) {
            final User user = new User();
            user.setUsername("john");
            user.setEmail("john@gmail.com");
            user.setPassword(encoder.encode("password"));
            user.setPrivileges(new HashSet<>(Arrays.asList(privilege1)));
            userRepository.save(user);
        }

        if (userRepository.findByUsername("tom") == null) {
            final User user = new User();
            user.setUsername("tom");
            user.setEmail("tom@gmail.com");
            user.setPassword(encoder.encode("password"));
            user.setPrivileges(new HashSet<>(Arrays.asList(privilege1, privilege2)));
            userRepository.save(user);
        }
    }




}

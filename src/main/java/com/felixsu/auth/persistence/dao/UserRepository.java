package com.felixsu.auth.persistence.dao;

import com.felixsu.auth.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created on 10/22/17.
 *
 * @author felixsoewito
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(final String username);

    @Transactional
    void removeUserByUsername(String username);
}

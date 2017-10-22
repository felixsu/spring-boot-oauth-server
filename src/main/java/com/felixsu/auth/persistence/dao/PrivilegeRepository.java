package com.felixsu.auth.persistence.dao;

import com.felixsu.auth.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 10/22/17.
 *
 * @author felixsoewito
 */
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

    Privilege findByName(String name);
}

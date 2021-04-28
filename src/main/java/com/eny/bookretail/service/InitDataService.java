package com.eny.bookretail.service;

import com.eny.bookretail.enums.RoleName;
import com.eny.bookretail.model.RoleEntity;
import com.eny.bookretail.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

@Service
public class InitDataService {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void createRoles() {

        if (roleRepository.count() == 0) {
            LinkedList<RoleEntity> roles = new LinkedList<>();

            roles.add(new RoleEntity(RoleName.ROLE_ADMIN));
            roles.add(new RoleEntity(RoleName.ROLE_USER));

            roleRepository.saveAll(roles);
        }
    }
}

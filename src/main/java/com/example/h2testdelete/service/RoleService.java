package com.example.h2testdelete.service;

import com.example.h2testdelete.entity.Role;
import com.example.h2testdelete.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> findByName (String name) {
        return roleRepository.findByName(name);
    }

}

package com.example.h2testdelete.service;

import com.example.h2testdelete.entity.Role;
import com.example.h2testdelete.entity.User;
import com.example.h2testdelete.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleService roleService;

    public User save (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleService.findByName("ROLE_USER").get(); //TODO сделать назначение выбираемой роли и проверку на наличие роли в таблице
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", username)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}


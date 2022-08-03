package com.example.alex90bar.mytest.service;

import static java.util.Collections.singletonList;

import com.example.alex90bar.mytest.model.UserEntity;
import com.example.alex90bar.mytest.repository.UserRepository;
import java.util.Collection;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserDetailsServiceImpl
 *
 * @author alex90bar
 */

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username){
    Optional<UserEntity> userOptional = userRepository.findByUserName(username);
    UserEntity userEntity = userOptional
        .orElseThrow(() -> new UsernameNotFoundException("No user " +
            "found with username : " + username));

    return new org.springframework.security
        .core.userdetails.User(userEntity.getUserName(), userEntity.getPassword(),
        true, true, true,
        true, getAuthorities("USER"));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
    return singletonList(new SimpleGrantedAuthority(role));
  }

}



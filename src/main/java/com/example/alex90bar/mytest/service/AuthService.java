package com.example.alex90bar.mytest.service;

import com.example.alex90bar.mytest.api.request.LoginRq;
import com.example.alex90bar.mytest.api.request.RegisterRq;
import com.example.alex90bar.mytest.api.response.AuthRs;
import com.example.alex90bar.mytest.model.UserEntity;
import com.example.alex90bar.mytest.repository.UserRepository;
import com.example.alex90bar.mytest.security.JwtProvider;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * AuthService
 *
 * @author alex90bar
 */

@Service
@AllArgsConstructor
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtProvider jwtProvider;
  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;

  @Transactional
  public void signup(RegisterRq registerRequest) {
    UserEntity user = new UserEntity();
    user.setUserName(registerRequest.getName());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    userRepository.save(user);
  }


  public AuthRs login(LoginRq loginRq) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRq.getName(), loginRq.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtProvider.generateToken(authentication);
    return new AuthRs(token, loginRq.getName());
  }


}



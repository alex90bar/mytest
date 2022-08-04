package com.example.alex90bar.mytest.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.alex90bar.mytest.api.request.LoginRq;
import com.example.alex90bar.mytest.security.JwtProvider;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.BadCredentialsException;

@SpringBootTest
class AuthServiceTest {

  private final AuthService authService;
  private final JwtProvider jwtProvider;

  @Autowired
  AuthServiceTest(AuthService authService, JwtProvider jwtProvider) {
    this.authService = authService;
    this.jwtProvider = jwtProvider;
  }


  @Test
  void loginTest() {
    String user = "user";
    String pass = "pass";
    String token = authService.login(new LoginRq(user, pass)).getAuthenticationToken();
    assertEquals(user, jwtProvider.getUserNameFromJwt(token));
  }

  @Test
  void loginFailTest() {
    String user = "user_fake";
    String pass = "pass_fake";
    assertThrows(BadCredentialsException.class, () -> {
      authService.login(new LoginRq(user, pass));
    });
  }
}
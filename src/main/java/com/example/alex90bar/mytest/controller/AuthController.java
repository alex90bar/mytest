package com.example.alex90bar.mytest.controller;

import com.example.alex90bar.mytest.api.request.LoginRq;
import com.example.alex90bar.mytest.api.request.RegisterRq;
import com.example.alex90bar.mytest.api.response.AuthRs;
import com.example.alex90bar.mytest.service.AuthService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 *
 * @author alex90bar
 */

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public AuthRs login(@RequestBody @Valid LoginRq loginRq){
    return authService.login(loginRq);
  }

  @PostMapping("/signup")
  public ResponseEntity<String> signup(@RequestBody @Valid  RegisterRq registerRq){
    authService.signup(registerRq);
    return new ResponseEntity<>("User registration Successful", HttpStatus.OK);
  }

}



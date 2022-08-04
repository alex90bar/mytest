package com.example.alex90bar.mytest.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

  private final MockMvc mockMvc;

  @Autowired
  AuthControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  public void correctLoginTest() throws Exception{
    mockMvc.perform(post("/api/auth/login")
        .contentType(MediaType.APPLICATION_JSON).content("{\n"
            + "    \"name\": \"user\",\n"
            + "    \"password\": \"pass\"\n"
            + "}"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  public void failedLoginTest() throws Exception{
    mockMvc.perform(post("/api/auth/login")
        .contentType(MediaType.APPLICATION_JSON).content("{\n"
            + "    \"name\": \"fake_user\",\n"
            + "    \"password\": \"fake_pass\"\n"
            + "}"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }


}
package com.example.alex90bar.mytest.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MessageControllerTest {

  private final MockMvc mockMvc;

  @Autowired
  MessageControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  @WithMockUser(username = "user", password = "pass")
  public void getMessagesListTest() throws Exception{
    mockMvc.perform(post("/api/message")
        .contentType(MediaType.APPLICATION_JSON).content("{\n"
        + "    \"name\": \"user\",\n"
        + "    \"message\": \"history 10\"\n"
        + "}"))
        .andDo(print())
        .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void getMessagesListFailTest() throws Exception{
    mockMvc.perform(post("/api/message")
        .contentType(MediaType.APPLICATION_JSON).content("{\n"
            + "    \"name\": \"user_fake\",\n"
            + "    \"message\": \"history 10\"\n"
            + "}"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }

  @Test
  @WithMockUser(username = "user", password = "pass")
  public void postBlankMessageValidationTest() throws Exception{
    mockMvc.perform(post("/api/message")
        .contentType(MediaType.APPLICATION_JSON).content("{\n"
            + "    \"name\": \"user\",\n"
            + "    \"message\": \" \"\n"
            + "}"))
        .andDo(print())
        .andExpect(status().is4xxClientError());
  }

}
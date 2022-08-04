package com.example.alex90bar.mytest.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.alex90bar.mytest.api.request.MessageRq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageServiceTest {

  private final MessageService messageService;

  @Autowired
  MessageServiceTest(MessageService messageService) {
    this.messageService = messageService;
  }

  @Test
  public void getLast10MessagesTest(){
    assertNotNull(messageService.listenMessage(new MessageRq("user", "history 10")));
  }

}
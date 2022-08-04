package com.example.alex90bar.mytest.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.alex90bar.mytest.model.MessageEntity;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessageRepositoryTest {

  private final MessageRepository messageRepository;

  @Autowired
  MessageRepositoryTest(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Test
  public void getLast10MessagesTest(){
    Long currentTime = System.currentTimeMillis();

    List<MessageEntity> messageEntities = messageRepository
        .findTop10ByTimeCreatedBeforeOrderByTimeCreatedDesc(currentTime);

    assertNotNull(messageEntities);

    for (MessageEntity messageEntity : messageEntities){
      assertTrue(messageEntity.getTimeCreated() < currentTime);
    }

  }
}
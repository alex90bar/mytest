package com.example.alex90bar.mytest.service;

import com.example.alex90bar.mytest.api.mapper.MessageMapper;
import com.example.alex90bar.mytest.api.request.MessageRq;
import com.example.alex90bar.mytest.api.response.MessageRs;
import com.example.alex90bar.mytest.model.MessageEntity;
import com.example.alex90bar.mytest.repository.MessageRepository;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * MessageService
 *
 * @author alex90bar
 */

@Slf4j
@Service
@AllArgsConstructor
public class MessageService {

  private final MessageRepository messageRepository;
  private final MessageMapper mapper;

  public List<MessageRs> listenMessage(MessageRq messageRq) {
    if (!messageRq.getMessage().equals("history 10")) {

      MessageEntity messageEntity = mapper.mapMessageRqToEntity(messageRq);
      messageRepository.save(messageEntity);

      return new ArrayList<>();
    } else {

      List<MessageEntity> messages = messageRepository
          .findTop10ByTimeCreatedBeforeOrderByTimeCreatedDesc(System.currentTimeMillis());

      return messages.stream().map(mapper::mapMessageEntityToMessageRs)
          .collect(Collectors.toList());
    }
  }
}



package com.example.alex90bar.mytest.controller;

import com.example.alex90bar.mytest.api.request.MessageRq;
import com.example.alex90bar.mytest.api.response.MessageRs;
import com.example.alex90bar.mytest.model.MessageEntity;
import com.example.alex90bar.mytest.service.AuthService;
import com.example.alex90bar.mytest.service.MessageService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * MessageController
 *
 * @author alex90bar
 */

@RestController
@AllArgsConstructor
@Transactional
@RequestMapping("/api/message")
public class MessageController {

  private final MessageService messageService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<MessageRs> listenMessage(@RequestBody MessageRq messageRq){
    return messageService.listenMessage(messageRq);
  }


}



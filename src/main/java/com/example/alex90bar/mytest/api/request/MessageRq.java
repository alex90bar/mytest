package com.example.alex90bar.mytest.api.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MessageAddRq
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRq {

  private String name;
  private String message;

}



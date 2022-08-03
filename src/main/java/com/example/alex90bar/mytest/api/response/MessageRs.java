package com.example.alex90bar.mytest.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MessageRs
 *
 * @author alex90bar
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRs {

  private String name;
  private String message;
  private String timeCreated;

}



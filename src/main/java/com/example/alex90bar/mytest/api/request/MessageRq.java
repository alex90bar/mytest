package com.example.alex90bar.mytest.api.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String name;
  @NotBlank(message = "Ошибка! Поле не может быть пустым")
  @Size(min = 2, message = "Ошибка! Минимальная длина - 2 знака")
  private String message;

}



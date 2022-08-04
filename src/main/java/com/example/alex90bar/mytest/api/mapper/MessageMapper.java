package com.example.alex90bar.mytest.api.mapper;

import com.example.alex90bar.mytest.api.request.MessageRq;
import com.example.alex90bar.mytest.api.response.MessageRs;
import com.example.alex90bar.mytest.model.MessageEntity;
import java.text.DateFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * MessageMapper
 *
 * @author alex90bar
 */

@Mapper(componentModel = "spring")
public interface MessageMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "message", source = "message")
  @Mapping(target = "userName", source = "name")
  @Mapping(target = "timeCreated", expression = "java(System.currentTimeMillis())")
  MessageEntity mapMessageRqToEntity(MessageRq messageRq);

  @Mapping(target = "message", source = "message")
  @Mapping(target = "name", source = "userName")
  @Mapping(target = "timeCreated", expression = "java(generateTimeCreated(messageEntity.getTimeCreated()))")
  MessageRs mapMessageEntityToMessageRs(MessageEntity messageEntity);

  default String generateTimeCreated(Long timeCreated){
    return DateFormat.getDateTimeInstance().format(timeCreated);
  };

}

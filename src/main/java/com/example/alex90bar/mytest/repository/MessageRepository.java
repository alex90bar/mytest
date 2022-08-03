package com.example.alex90bar.mytest.repository;

import com.example.alex90bar.mytest.model.MessageEntity;
import com.example.alex90bar.mytest.model.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MessageRepository
 *
 * @author alex90bar
 */

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {


  List<MessageEntity> findTop10ByTimeCreatedBeforeOrderByTimeCreatedDesc(Long timeCreated);


}

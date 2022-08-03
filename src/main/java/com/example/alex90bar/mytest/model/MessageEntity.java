package com.example.alex90bar.mytest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * MessageEntity
 *
 * @author alex90bar
 */

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "message")
public class MessageEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", nullable = false)
  private String userName;

  @Column(name = "message", nullable = false)
  private String message;

  @Column(name = "time_created", nullable = false)
  private Long timeCreated;

}



package com.example.alex90bar.mytest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MytestApplicationTests {

  private final MytestApplication mytestApplication;

  @Autowired
  MytestApplicationTests(MytestApplication mytestApplication) {
    this.mytestApplication = mytestApplication;
  }

  @Test
  void contextLoads() {
    assertNotNull(mytestApplication);
  }

}

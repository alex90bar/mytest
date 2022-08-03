package com.example.alex90bar.mytest.repository;

import com.example.alex90bar.mytest.model.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author alex90bar
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByUserName(String username);

}

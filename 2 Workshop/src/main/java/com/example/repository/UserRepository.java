package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<User> findByUserNameAndPassword(String username, String password);

    @Query("SELECT u.userName FROM User u "+
          "ORDER BY  u.userName")
    List<String> findAllUsernames();

    Optional<User>findByUserName(String username);
}

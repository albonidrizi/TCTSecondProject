package com.tct.SecondProject.repository;

import com.tct.SecondProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
    User findByVerificationToken (String verificationToken);
}

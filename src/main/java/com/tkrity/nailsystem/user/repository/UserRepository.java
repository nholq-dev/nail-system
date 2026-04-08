package com.tkrity.nailsystem.user.repository;

import com.tkrity.nailsystem.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findUserByUserCode(String userCode);
}

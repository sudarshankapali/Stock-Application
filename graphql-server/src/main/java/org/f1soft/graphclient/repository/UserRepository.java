package org.f1soft.graphclient.repository;

import org.f1soft.graphclient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT user.userId FROM User user")
    List<String> getAllUserId();
}

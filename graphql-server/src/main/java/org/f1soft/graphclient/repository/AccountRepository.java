package org.f1soft.graphclient.repository;

import org.f1soft.graphclient.entity.Accounts;
import org.f1soft.graphclient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Accounts,String> {
    List<Accounts> findByUser(User user);
}

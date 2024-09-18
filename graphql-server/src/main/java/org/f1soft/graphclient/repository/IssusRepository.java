package org.f1soft.graphclient.repository;

import org.f1soft.graphclient.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssusRepository extends JpaRepository<Issue,String> {
    @Query("SELECT issue.id FROM Issue issue")
    List<String> getAllIssueId();
}

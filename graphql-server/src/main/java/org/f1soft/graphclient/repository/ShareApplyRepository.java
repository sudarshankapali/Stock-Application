package org.f1soft.graphclient.repository;

import org.f1soft.graphclient.entity.ShareApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShareApplyRepository extends JpaRepository<ShareApply,Long> {
@Query("SELECT apply FROM ShareApply apply WHERE apply.userId=:userId")
List<ShareApply> findByUserId(String userId);

    @Query("SELECT apply.applicationId FROM ShareApply apply WHERE apply.userId=:userId")
    List<String> findApplicationIdById(String userId);
}

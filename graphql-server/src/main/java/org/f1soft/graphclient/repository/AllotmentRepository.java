package org.f1soft.graphclient.repository;

import org.f1soft.graphclient.entity.Allotments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AllotmentRepository extends JpaRepository<Allotments, String> {
    @Query("SELECT allot.noOfAllotments FROM Allotments allot where allot.applicationId =:applicationId and allot.issueId=:issueId")
    int getNoOfAllotments(String applicationId, String issueId);
}

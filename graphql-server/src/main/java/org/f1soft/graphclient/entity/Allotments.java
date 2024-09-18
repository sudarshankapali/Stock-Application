package org.f1soft.graphclient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Allotments {
    @Id
    private String applicationId;
    private String issueId;
    private int noOfAllotments;
}

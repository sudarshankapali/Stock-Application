package com.f1soft.ipo_result_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="allotment_result")
public class Allotments {
    @Id
    private String applicationId;
    private String issueId;
    private int noOfAllotments;
}

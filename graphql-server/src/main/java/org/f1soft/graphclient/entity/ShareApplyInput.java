package org.f1soft.graphclient.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShareApplyInput {
    private Long id;

    private String userId;

    private String accountNumber;

    private String issueId;

    private Integer appliedQuantity;

    private String crn;

    private String applicationId;
}

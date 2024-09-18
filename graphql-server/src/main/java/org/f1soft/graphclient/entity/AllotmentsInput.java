package org.f1soft.graphclient.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllotmentsInput {
    private String applicationId;
    private String issueId;
    private int noOfAllotments;
}

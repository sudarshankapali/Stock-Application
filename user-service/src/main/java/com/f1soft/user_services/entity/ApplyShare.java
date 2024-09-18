package com.f1soft.user_services.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplyShare {

    private Long id;
    private String userId;
    private String accountNumber;
    private String issueId;
    private Integer appliedQuantity;
    private String crn;
}

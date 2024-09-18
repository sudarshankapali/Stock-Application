package com.f1soft.user_services.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer_accounts")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Accounts {

    @Id
    private String accountNumber;

    private String accountHolderName;

    @ManyToOne
    @JoinColumn(name="branch_id")
    @JsonIgnoreProperties("accounts")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
}

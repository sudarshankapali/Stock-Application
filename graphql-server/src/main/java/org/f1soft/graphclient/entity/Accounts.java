package org.f1soft.graphclient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer_accounts")
@Getter
@Setter
public class Accounts {
    @Id
    private String accountNumber;
    private String accountHolderName;

    @ManyToOne
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}

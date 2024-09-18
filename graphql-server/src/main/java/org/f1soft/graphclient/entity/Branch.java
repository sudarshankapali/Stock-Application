package org.f1soft.graphclient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="branch_information")
@Getter
@Setter
public class Branch {

    @Id
    private String branchId;
    private String branchName;

    @OneToMany(mappedBy = "branch")
    private Set<Accounts> accounts;

    @ManyToOne
    @JoinColumn(name="bank_id")
    private Bank bank;

}

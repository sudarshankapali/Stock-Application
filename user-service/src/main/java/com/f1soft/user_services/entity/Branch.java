package com.f1soft.user_services.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonIgnoreProperties("branch")
    private Set<Accounts> accounts;

    @ManyToOne
    @JoinColumn(name="bank_id")
    @JsonBackReference
    private Bank bank;

}

package com.f1soft.user_services.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="bank_information")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bank {

    @Id
    private String bankId;
    private String bankName;

    @OneToMany(mappedBy = "bank")
    @JsonManagedReference
    private List<Branch> branchList;
}

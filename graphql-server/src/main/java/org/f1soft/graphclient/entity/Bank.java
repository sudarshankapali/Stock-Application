package org.f1soft.graphclient.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="bank_information")
public class Bank {
    @Id

    private String bankId;

    private String bankName;

    @OneToMany(mappedBy = "bank")
    @JsonManagedReference
    private List<Branch> branchList;
}
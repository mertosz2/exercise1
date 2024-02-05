package com.example.ex1kbtg.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "profile")
public class Profile {

    @Id
    private String email;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "profile")
    private List<Wallet> wallet;
}

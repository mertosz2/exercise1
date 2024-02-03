package com.example.ex1kbtg.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    private Integer id;

    @JsonProperty("walletNameT")
    @NotNull(message = "required name")
    @Size(min = 1, max = 256)
    private String name;
}

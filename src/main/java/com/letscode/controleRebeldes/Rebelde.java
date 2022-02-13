package com.letscode.controleRebeldes;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rebelde {
    //@NotNull(message = "O nome está nulo")
    private String Nome;
    //@NotNull(message = "O valor está nulo")
    private int Idade;
    //@NotNull(message = "A raça está vazia")
    private Raca Raca;

    public Rebelde(String nome, int idade, com.letscode.controleRebeldes.Raca raca) {
        Nome = nome;
        Idade = idade;
        Raca = raca;
    }
}

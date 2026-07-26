package com.Uniamerica.Atividade_1.Entity;

import lombok.Data;

@Data
public class Entrada {

    private String nome;
    private Integer idade;
    private Boolean gestante = (false);
    private Boolean pessoaComDeficiencia = (false);

}

package com.brunihn.pokemon.model;

import lombok.Data;
@Data  //gera automaticamente getter,setters , ToString,Equals,HashCode

public class Pokemon {

    private String nome;
    private String tipo;  //String provisorio pois Enum vai trabalhar melhor no futuro
    private Integer level;
    private Boolean lendario;
    private String classificacao;
    private String mensagem;


}

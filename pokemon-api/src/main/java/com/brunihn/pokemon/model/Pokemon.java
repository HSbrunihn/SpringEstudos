package com.brunihn.pokemon.model;

import lombok.Data;
import lombok.NonNull;

@Data  //gera automaticamente getter,setters , ToString,Equals,HashCode

public class Pokemon {

    private String nome;
    private String tipo;//String provisorio pois Enum vai trabalhar melhor no futuro
    private Integer level=0;
    private Boolean lendario=(false);
    private String classificacao;
    private String mensagem;


}

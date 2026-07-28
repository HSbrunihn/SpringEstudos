package com.brunihn.dragon_dex_api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data          //gera getter e setters automaticos
@AllArgsConstructor
@NoArgsConstructor
public class Dragon {
    private Long id;
    private String nome;
    private String classe;
    private Integer nivelPerigo;
    private String descricao;
    private String imagem;      //vai ser utilizado links para as imagens ...

}

package com.Uniamerica.Atividade_1.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Saida {
 private String nome;
 private String tipoAtendimento;
 private String mensagem;

}

package com.Uniamerica.Atividade_1.Service;


import com.Uniamerica.Atividade_1.Entity.Entrada;
import com.Uniamerica.Atividade_1.Entity.Saida;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {

    public Saida classificar ( Entrada entrada) {

        boolean prioritario = entrada.getIdade() >= 60
                || Boolean.TRUE.equals(entrada.getGestante())
                || Boolean.TRUE.equals(entrada.getPessoaComDeficiencia());

        if (prioritario) {
            return new Saida(
                    entrada.getNome(),
                    "PRIORITARIO",
                    "Pessoa com direito a atendimento prioritário."
            );
        }
        return new Saida(
                entrada.getNome(),
                "NORMAL",
                "Pessoa sem direito a atendimento prioritário."
        );
    }
}

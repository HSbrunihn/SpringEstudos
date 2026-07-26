package com.Uniamerica.Atividade_1.Controller;


import com.Uniamerica.Atividade_1.Entity.Entrada;
import com.Uniamerica.Atividade_1.Entity.Saida;
import com.Uniamerica.Atividade_1.Service.AtendimentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService){
        this.atendimentoService = atendimentoService;

    }
    @PostMapping("classificar")
    public Saida classificar(@RequestBody Entrada entrada){
        return  atendimentoService.classificar(entrada);
    }
}

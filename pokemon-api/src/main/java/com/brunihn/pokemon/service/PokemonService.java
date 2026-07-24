package com.brunihn.pokemon.service;
import com.brunihn.pokemon.model.Pokemon;
import org.springframework.stereotype.Service;

@Service

public class PokemonService {

    public Pokemon classificar(Pokemon pokemon){
        boolean isLendario = Boolean.TRUE.equals(pokemon.getLendario());

        if (pokemon.getLevel() >=50 && isLendario){
            //classifa como forte
            pokemon.setClassificacao("PODEROSO");
            pokemon.setMensagem("Parabens voce tem um pokemon extremamente poderoso!");
        }else{
            //classifica como iniciante

            pokemon.setClassificacao("INICIANTE");
            pokemon.setMensagem("Parabens pelo seu pokemon ,ainda tem muito o que treinar ..");
        }


        return pokemon;
    }
}

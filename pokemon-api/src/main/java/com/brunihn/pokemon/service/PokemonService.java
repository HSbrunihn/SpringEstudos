package com.brunihn.pokemon.service;
import com.brunihn.pokemon.model.Pokemon;
import org.springframework.stereotype.Service;

@Service

public class PokemonService {

    public Pokemon classificar(Pokemon pokemon){

        if (pokemon.getLevel() >=50 || pokemon.getLendario()){
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

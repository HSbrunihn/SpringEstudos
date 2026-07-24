package com.brunihn.pokemon.controller;

import com.brunihn.pokemon.model.Pokemon;
import com.brunihn.pokemon.service.PokemonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemon") // quando alguem fizer um POST , executara este metodo

public class PokemonController {

    //atributos de classe no topo
    private final PokemonService pokemonService;

    //contrutor
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //Endpoint POST

    //@RequestBody O Spring pega o corpo(body) da requisicao HTTP e transforma em um objeto
    //nesse caso (Pokemon)
    @PostMapping("/classificar")
    public Pokemon classificar(@RequestBody Pokemon pokemon){

        //chama a regra de negocio passando o objeto recebido

        return pokemonService.classificar(pokemon);
    }



}

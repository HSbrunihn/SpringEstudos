package com.brunihn.dragon_dex_api.repository;

import com.brunihn.dragon_dex_api.model.Dragon;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DragonRepositoryImpl implements DragonRepository{

    private Map<Long, Dragon> dragons = new HashMap<>();
    private Long proximoId = 1L;



    //============================================
    @Override
    public Dragon salvar(Dragon dragon) {

        dragon.setId(proximoId);
        dragons.put(dragon.getId(), dragon);
        proximoId++;
        return dragon;
    }

    @Override
    public List<Dragon> listarTodos() {
        return new ArrayList<>(dragons.values());
    }

    @Override
    public Optional<Dragon> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public Dragon atualizar(Dragon dragon) {
        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}

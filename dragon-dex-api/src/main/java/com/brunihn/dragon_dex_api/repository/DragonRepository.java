package com.brunihn.dragon_dex_api.repository;

import com.brunihn.dragon_dex_api.model.Dragon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DragonRepository {

Dragon salvar(Dragon dragon);
List<Dragon>listarTodos();
Optional<Dragon> buscarPorId(Long id);
Dragon atualizar(Dragon dragon);
void excluir(Long id);

}

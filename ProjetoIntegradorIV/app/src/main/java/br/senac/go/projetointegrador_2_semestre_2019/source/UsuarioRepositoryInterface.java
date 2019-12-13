package br.senac.go.projetointegrador_2_semestre_2019.source;

import java.util.List;

import br.senac.go.projetointegrador_2_semestre_2019.model.Usuario;

public interface UsuarioRepositoryInterface {

    void getAll(RepositoyCallBack<List<Usuario>> callBack);
}

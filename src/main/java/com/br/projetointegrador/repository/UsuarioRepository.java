package com.br.projetointegrador.repository;

import com.br.projetointegrador.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}

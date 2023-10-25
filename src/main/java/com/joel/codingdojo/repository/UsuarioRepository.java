package com.joel.codingdojo.repository;

import com.joel.codingdojo.model.Usuario;

public interface UsuarioRepository extends RepositoryBase <Usuario>{
    Usuario findByEmail(String email);
}

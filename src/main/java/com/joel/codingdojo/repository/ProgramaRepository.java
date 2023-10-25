package com.joel.codingdojo.repository;

import com.joel.codingdojo.model.Programa;

public interface ProgramaRepository extends RepositoryBase<Programa>{
    Programa findByTitle(String title);
}

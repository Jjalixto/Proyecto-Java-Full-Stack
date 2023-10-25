package com.joel.codingdojo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joel.codingdojo.model.Programa;
import com.joel.codingdojo.repository.ProgramaRepository;

@Service
public class ProgramaService extends ServiceBase<Programa>{
    
    @Autowired
    ProgramaRepository repository;

    public ProgramaService(ProgramaRepository repositoryBase){
        super(repositoryBase);
    }


    public Programa findByTitle(String title){
        Programa optional = repository.findByTitle(title);
        if(optional == null){
            return optional;
        }else{
            return null;
        }
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

package com.joel.codingdojo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.joel.codingdojo.repository.RepositoryBase;
@Service
public abstract class ServiceBase<T>{

    RepositoryBase<T> repositoryBase;

    public ServiceBase(RepositoryBase<T> repositoryBase){
        this.repositoryBase = repositoryBase;
    }

    public List<T> findAll(){
        return repositoryBase.findAll();
    }

    public T save (T object){
        return repositoryBase.save(object);
    }

    public T findById(Long id){
        Optional<T> optional = repositoryBase.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            return null;
        }
    }
}

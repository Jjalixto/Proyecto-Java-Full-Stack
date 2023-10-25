package com.joel.codingdojo.service;

import org.springframework.stereotype.Service;

import com.joel.codingdojo.model.Calificaciones;
import com.joel.codingdojo.repository.CalificacionesRepositoy;

@Service
public class CalificacionesService extends ServiceBase<Calificaciones> {

    public CalificacionesService(CalificacionesRepositoy calificacionesRepositoy) {
        super(calificacionesRepositoy);
    }
    
}

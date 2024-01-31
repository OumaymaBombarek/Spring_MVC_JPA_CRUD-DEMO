package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dao.DepartamentoDao;
import com.example.entities.Departamento;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class DepartamentoServiceImpl implements DepartamentoService  {

    // Inyeccion de dependencia por constructor
    /*
     *  Antiguamente para inyectar una dependencia con constructor 
     *  primero: Declarar la variable del tipo del objeto
     *  Segundo: Crear el constructor y le pasabas el objeto
     * Pero actualmente con lombok lo anterior no es necesario, se facilita solamente declarando
     * l avariable de objeto y especificando el modificador final  y utilizando la anotacion de 
     * lombok @RequiredArgsConstructor
     * 
     * Antiguo 
     * private Departamento departamento;
    public DepartamentoServiceImpl(DepartamentoDao departamentoDao);
    this.departamentoDao = departamentoDao;
     */
    // No hay que ovidar la anotacion de lombok
     private final DepartamentoDao departamentoDao;


    
    @Override
    public List<Departamento> departamentos() {
        return departamentoDao.findAll();
    }

    @Override
    public Departamento dameUnDepartamento(int idDepartamento) {

        return departamentoDao.findById(idDepartamento).get();
       
    }

}

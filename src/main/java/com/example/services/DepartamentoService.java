package com.example.services;

import java.util.List;

import com.example.entities.Departamento;

public interface DepartamentoService  {

    // Aqui solo necesito que me duelve todos los deparatamenmto

    public List<Departamento> departamentos();
    public Departamento dameUnDepartamento(int idDepartamento);

}

package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Departamento;

@Repository // para crear beans de datos

public interface DepartamentoDao extends JpaRepository<Departamento,Integer>{



}

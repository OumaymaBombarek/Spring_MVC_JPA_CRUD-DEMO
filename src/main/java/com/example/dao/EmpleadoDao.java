package com.example.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Empleado;
@Repository // anotacion me va generar todos los metpdos basicos de dao 

public interface EmpleadoDao extends JpaRepository<Empleado, Integer> {

  List<Empleado> findByNombre(String nombre);
  



}

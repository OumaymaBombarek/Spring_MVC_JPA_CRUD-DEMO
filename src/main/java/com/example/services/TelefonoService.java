package com.example.services;

import java.util.List;

import com.example.entities.Telefono;

public interface TelefonoService {
 // Todos los telefonos de un empleado

    public List<Telefono> telefonos(int idEmpleado);

  // Para borrar telefonos de un empleado
  
  public void eliminarTelefonos(int idEmpleado);

  public void persistirTelefono( int idEmpleado, Telefono telefono);


}

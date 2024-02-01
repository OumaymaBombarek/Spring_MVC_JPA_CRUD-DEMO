package com.example.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// para que esta clase crea una tabla eempleado hay que hacer las anotaciones siguientes
// para convertir la clase en identidad
@Entity
@Table(name = "empleados")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor


// serializar convertir de objeto a una coleccion hace falta un nhjumero de 
//serializacion para hacer el desserializar con este condigo para ello se implimenta 
// la clase empleado
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para autoincrementar el id


    private int id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    @DateTimeFormat(pattern = "yyyy-MM-d") // hay que especificar en que forma se guarda años-mes-dia 
    private LocalDate fechaAlta;
    private double salario;

    @Enumerated(EnumType.STRING) // con esto coge el nombre y no el ordinal
    private Genero genero;


    // para que pertenezca a un departamento
    // muchos empleados puedenm pertenecer a un deapartamento- cascade update and delete
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)

    private Departamento departamento;

    // como se relacionan 

     @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Telefono> telefonos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Correo> correos;

    

}

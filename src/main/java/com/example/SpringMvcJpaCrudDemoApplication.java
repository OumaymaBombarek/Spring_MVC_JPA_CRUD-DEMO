package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entities.Correo;
import com.example.entities.Departamento;
import com.example.entities.Empleado;
import com.example.entities.Genero;
import com.example.entities.Telefono;
import com.example.services.CorreoService;
import com.example.services.DepartamentoService;
import com.example.services.EmpleadoService;
import com.example.services.TelefonoService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor

public class SpringMvcJpaCrudDemoApplication implements CommandLineRunner {

	private final EmpleadoService empleadoService;
	private final DepartamentoService departamentoService;
	private final TelefonoService telefonoService;
	private final CorreoService correoService;
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJpaCrudDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear departamento porque es el padre de todas las entidades

		Departamento dpt1 = Departamento.builder()
							.nombre("RRHH")
							.build();
		Departamento dpt2 = Departamento.builder()
							.nombre("INFORMATICA")
							.build();
		
		Departamento dpt3 = Departamento.builder()
							.nombre("CONTABILIDAD")
							.build();

		departamentoService.persistirDpto(dpt1);
		departamentoService.persistirDpto(dpt2);
		departamentoService.persistirDpto(dpt3);
		// Empleados
		
		Empleado empleado1 = Empleado.builder()
							.nombre("Oumayma")
							.primerApellido("Bombarek")
							.fechaAlta(LocalDate.of(1993, 10, 2))
							.departamento(departamentoService.dameUnDepartamento(1))
							.genero(Genero.MUJER)
							.salario(3000)
							.build();

		Empleado empleado2 = Empleado.builder()
							.nombre("Rosa")
							.primerApellido("Aurora")
							.fechaAlta(LocalDate.of(1997, 11, 7))
							.departamento(departamentoService.dameUnDepartamento(3))
							.genero(Genero.OTRO)
							.salario(4000)
							.build();



		empleadoService.persistirEmpleado(empleado1);
		empleadoService.persistirEmpleado(empleado2);
		// Crear Telefonos 

		//List<Telefono> telefonosEmpleado1 = new ArrayList<>();

		Telefono telefono1Empleado1 = Telefono.builder()
									.numero("56798432")
									.empleado(empleadoService.dameUnEmpleado(1))
									.build();

		Telefono telefono2Empleado1 = Telefono.builder()
									.numero("9875432")
									.empleado(empleadoService.dameUnEmpleado(1))
									.build();

		//telefonosEmpleado1.add(telefono1Empleado1);
		//telefonosEmpleado1.add(telefono2Empleado1);
		telefonoService.persistirTelefono(1, telefono1Empleado1);
		telefonoService.persistirTelefono(1, telefono2Empleado1);


		//List<Telefono> telefonosEmpleado2 = new ArrayList<>();

		Telefono telefono1Empleado2 = Telefono.builder()
									.numero("56798")
									.empleado(empleadoService.dameUnEmpleado(2))
									.build();

		Telefono telefono2Empleado2 = Telefono.builder()
									.numero("9875")
									.empleado(empleadoService.dameUnEmpleado(2))
									.build();

		telefonoService.persistirTelefono(2, telefono1Empleado2);
		telefonoService.persistirTelefono(2, telefono2Empleado2);

		//telefonosEmpleado2.add(telefono1Empleado2);
		//telefonosEmpleado2.add(telefono2Empleado2);
		
// Correos

		//List<Correo> correosEmpleado1 = new ArrayList<>();

		Correo correo1Empleado1 = Correo.builder()
									.correos("bbbb@gmail.com")
									.build();

		Correo correo2Empleado1 = Correo.builder()
								.correos("hhhhhh@gmail.fr")
								.build();

		//correosEmpleado1.add(correo1Empleado1);
		//correosEmpleado1.add(correo2Empleado1);
							
		
		//List<Correo> correosEmpleado2 = new ArrayList<>();

		Correo correo1Empleado2 = Correo.builder()
									.correos("bbbb@gmail.ma")
									
									.build();

		Correo correo2Empleado2 = Correo.builder()
								.correos("hhhhhh@gmail.es")
								
								.build();

		correoService.persistirCorreo(1, correo1Empleado1);
		correoService.persistirCorreo(1, correo2Empleado1);
		correoService.persistirCorreo(2, correo1Empleado2);
		correoService.persistirCorreo(2, correo2Empleado2);

		//correosEmpleado2.add(correo1Empleado2);
		//correosEmpleado2.add(correo2Empleado2);
							




	}

}

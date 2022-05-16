package com.das.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.das.repository.entity.Empleado;
import com.das.service.EmpleadoService;

@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoRestController {

	@Autowired
	EmpleadoService empleadoService;

	@Cacheable (value="miCacheEmpleados")
	@GetMapping
	public List<Empleado> listarEmpleados() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
		}
		return empleadoService.listar();
	}

	@CacheEvict(value="miCacheEmpleados", allEntries = true)
	@PostMapping
	public void insertarEmpleado(@RequestBody Empleado emp) {
		empleadoService.inserta(emp);
	}
}

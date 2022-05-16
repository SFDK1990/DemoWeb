package com.das.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.das.repository.entity.Usuario;
import com.das.service.EmpleadoService;

@Controller
public class DemoController {

	@Autowired
	EmpleadoService empleadoService;

	@GetMapping("/saludo")
	public String saluda(@RequestParam(name = "name", required = false, defaultValue = "Mundo") String name,
			Model model) {
		model.addAttribute("name", name);
		empleadoService.registrar(name);
		return "hola";
	}

	@GetMapping("/error")
	public String error_page() {
		return "error";
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")//Con esta funcionalidad solo puede acceder el rol admin
	@GetMapping("/listarEmpleados")
	public String listarEmp(Model model) {	
		model.addAttribute ("listaEmp", empleadoService.listar() );
		model.addAttribute ("listaEmpConE", empleadoService.listarFiltroNombre("e") );	
//		model.addAttribute ("listaJPA", empleadoService.listarConJPA( 2, "%a%" ) );		
				
		return "listarDeEmpleados";
	}
	
	
	//Nos devuelve el usuario auticado
	@GetMapping("/")
	public String index(Model model) {
		Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute ("usuario", u);
		return "index";
	}

}

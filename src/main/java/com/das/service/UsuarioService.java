package com.das.service;

import java.util.List;

import com.das.repository.entity.Usuario;

public interface UsuarioService {
	public List<Usuario> listar();
	Usuario buscarPorUsername(String username); 
}

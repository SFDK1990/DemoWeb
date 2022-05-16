package com.das.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.das.repository.UsuarioRepoJPA;
import com.das.repository.entity.Usuario;
import com.das.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	//private static Logger LOG = org.slf4j.LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	UsuarioRepoJPA usuarioDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public List<Usuario> listar() {
		return usuarioDAO.findAll();
	}
	
	//Encriptar el password
	@Override
	public Usuario buscarPorUsername(String username) {	
		//Usuario u = usuarioDAO.findById(username).get();
		//LOG.info("UsuarioServiceImpl - "+ u.getUsername() + ": "+ u.getPassword() + ": "+ passwordEncoder().encode( "holaMundo" ));
		return  usuarioDAO.findById(username).get();
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return usuarioDAO.findById(username).get(); //buscarPorUsername(username);
	}

}
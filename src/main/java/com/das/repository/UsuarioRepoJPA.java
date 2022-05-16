package com.das.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.das.repository.entity.Usuario;


@Repository
public interface UsuarioRepoJPA extends JpaRepository<Usuario, String>{

}

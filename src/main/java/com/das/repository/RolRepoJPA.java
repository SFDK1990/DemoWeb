package com.das.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.das.repository.entity.Rol;

@Repository
public interface RolRepoJPA extends JpaRepository<Rol, Integer>{

}

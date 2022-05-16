package com.das.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.das.repository.entity.Empleado;

@Repository
public interface EmpleadoRepoJPA extends JpaRepository<Empleado, Integer>, EmpleadoRepo {
	

	List<Empleado> findByIdGreaterThanAndNombreLike(Integer pID, String contiene);
}

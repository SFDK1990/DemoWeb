package com.das.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.das.repository.EmpleadoRepo;
import com.das.repository.entity.Empleado;

public class EmpleadoRepoImpl implements EmpleadoRepo {

	private static Logger LOG = LoggerFactory.getLogger(EmpleadoRepoImpl.class);

	@Override
	public void registrar(String nombre) {
		LOG.info("Se ha saludado al empleado: " + nombre);

	}

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Empleado> listarCuyoNombreContiene(String texto_nombre) {
		Query query = entityManager.createNativeQuery("SELECT * FROM empleado " + "WHERE upper(nombre) LIKE upper(?)",
				Empleado.class);
		query.setParameter(1, "%" + texto_nombre + "%");
		return query.getResultList();
	}

}

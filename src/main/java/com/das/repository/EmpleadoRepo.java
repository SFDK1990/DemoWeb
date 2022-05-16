package com.das.repository;

import java.util.List;

import com.das.repository.entity.Empleado;

public interface EmpleadoRepo {
	public void registrar (String nombre);
	public List<Empleado> listarCuyoNombreContiene(String texto_nombre);
}

package com.proyecto.empleados.service;

import java.util.List;

import com.proyecto.empleados.Entity.Empleado;

public interface IEmpleadoService {

    List<Empleado> getAllEmpleado();

    List<Empleado> getEmpleadoByName(String name);

    Empleado saveEmpleado(Empleado Empleado);

    Empleado getEmpleadoById(Long id);

    Empleado updateEmpleado(Empleado Empleado);

    void deleteEmpleadoById(Long id);

}

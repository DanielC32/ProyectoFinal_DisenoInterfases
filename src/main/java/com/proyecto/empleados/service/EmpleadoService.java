package com.proyecto.empleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.empleados.Entity.Empleado;
import com.proyecto.empleados.Repository.IEmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> getAllEmpleado() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado saveEmpleado(Empleado Empleado) {
        return empleadoRepository.save(Empleado);
    }

    @Override
    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public Empleado updateEmpleado(Empleado Empleado) {
        return empleadoRepository.save(Empleado);
    }

    @Override
    public void deleteEmpleadoById(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public List<Empleado> getEmpleadoByName(String name) {
        return empleadoRepository.findByNameContaining(name);
    }

}

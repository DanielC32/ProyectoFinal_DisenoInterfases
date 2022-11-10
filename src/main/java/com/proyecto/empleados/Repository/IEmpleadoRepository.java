package com.proyecto.empleados.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.empleados.Entity.Empleado;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("FROM Empleado s WHERE s.firstName LIKE :name OR s.lastName LIKE :name")
    public List<Empleado> findByNameContaining(@Param("name") String name);

}

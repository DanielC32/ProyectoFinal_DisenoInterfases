package com.proyecto.empleados.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.empleados.Entity.Cargo;

public interface ICargoRepository extends JpaRepository<Cargo, Long> {

    @Query("FROM Cargo c WHERE c.name like :name")
    List<Cargo> findByNameContaining(@Param("name") String title);

    @Query("FROM Cargo c WHERE c.fechainicio <= :fechainicio")
    List<Cargo> findByFechainicioLessThan(@Param("fechainicio") String fechainicio);

    @Query("FROM Cargo c ORDER BY name ASC")
    public List<Cargo> findAllSortByName();
}

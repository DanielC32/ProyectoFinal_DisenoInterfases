package com.proyecto.empleados.service;

import java.util.List;

import com.proyecto.empleados.Entity.Cargo;

public interface ICargoService {

    List<Cargo> getAllCargo();

    List<Cargo> getCargoByName(String name);

    List<Cargo> getCargoByFechainicio(String fechainicio);

    Cargo saveCargo(Cargo Cargo);

    Cargo getCargoById(Long id);

    Cargo updateCargo(Cargo Cargo);

    void deleteCargoById(Long id);

}

package com.proyecto.empleados.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.empleados.Entity.Cargo;
import com.proyecto.empleados.Repository.ICargoRepository;

@Service
public class CargoService implements ICargoService {

    private ICargoRepository CargoRepository;

    public CargoService(ICargoRepository CargoRepository) {
        this.CargoRepository = CargoRepository;
    }

    @Override
    public List<Cargo> getAllCargo() {
        return CargoRepository.findAllSortByName();
    }

    @Override
    public List<Cargo> getCargoByName(String name) {
        return CargoRepository.findByNameContaining(name);
    }

    @Override
    public List<Cargo> getCargoByFechainicio(String fechainicio) {
        return CargoRepository.findByFechainicioLessThan(fechainicio);
    }

    @Override
    public Cargo saveCargo(Cargo Cargo) {
        return CargoRepository.save(Cargo);
    }

    @Override
    public Cargo getCargoById(Long id) {
        return CargoRepository.getReferenceById(id);

    }

    @Override
    public void deleteCargoById(Long id) {
        CargoRepository.deleteById(id);
    }

    @Override
    public Cargo updateCargo(Cargo Cargo) {
        return CargoRepository.save(Cargo);
    }

}

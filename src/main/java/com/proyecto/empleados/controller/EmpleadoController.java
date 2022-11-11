package com.proyecto.empleados.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.empleados.Entity.Cargo;
import com.proyecto.empleados.Entity.Empleado;
import com.proyecto.empleados.Repository.ICargoRepository;
import com.proyecto.empleados.service.EmpleadoService;
import com.proyecto.empleados.service.CargoService;

@Controller
public class EmpleadoController {

    @Autowired
    private EmpleadoService EmpleadosService;
    @Autowired
    private CargoService CargosService;
    @Autowired
    private ICargoRepository cargoRepository;

    private List<Cargo> cargosList = new ArrayList<>();

    public EmpleadoController(EmpleadoService EmpleadosService, ICargoRepository cargoRepository) {
        this.EmpleadosService = EmpleadosService;
        this.cargoRepository = cargoRepository;

        this.cargosList = this.cargoRepository.findAllSortByName();
    }

    @GetMapping("/")
    public String loginEmpleados(Model model) {
        model.addAttribute("empleados", EmpleadosService.getAllEmpleado());
        return "empleados";
    }

    @GetMapping("/empleados")
    public String listEmpleados(Model model) {
        model.addAttribute("empleados", EmpleadosService.getAllEmpleado());
        return "empleados";
    }

    @GetMapping("/cargos")
    public String listCargos(Model model) {
        model.addAttribute("cargos", CargosService.getAllCargo());
        return "cargos";
    }

    @GetMapping("/empleados/new")
    public String createEmpleadoForm(Model model) {

        Empleado empleado = new Empleado();

        model.addAttribute("empleado", empleado);
        model.addAttribute("cargosList", cargosList);

        return "create_empleado";
    }

    @GetMapping("/cargos/new")
    public String createCargoForm(Model model) {

        Cargo cargo = new Cargo();

        model.addAttribute("cargo", cargo);

        return "create_cargo";
    }

    @PostMapping("/cargos")
    public String saveCargo(@ModelAttribute("cargo") Cargo cargo) {
        CargosService.saveCargo(cargo);
        return "redirect:/cargos";
    }
    
    @PostMapping("/empleados")
    public String saveEmpleado(@ModelAttribute("empleado") Empleado empleado) {
        EmpleadosService.saveEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/edit/{id}")
    public String editEmpleadoForm(@PathVariable Long id, Model model) {
        Empleado st = EmpleadosService.getEmpleadoById(id);

        model.addAttribute("empleado", st);
        model.addAttribute("cargosList", cargosList);

        return "edit_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String updateEmpleado(@PathVariable Long id,
            @ModelAttribute("empleado") Empleado empleado,
            Model model) {
        // sacar el estudiante de la b.d. por el id
        Empleado existentEmpleado = EmpleadosService.getEmpleadoById(id);
        // cargarlo
        existentEmpleado.setId(id);
        existentEmpleado.setFirstName(empleado.getFirstName());
        existentEmpleado.setLastName(empleado.getLastName());
        existentEmpleado.setEmail(empleado.getEmail());
        existentEmpleado.setCargos(empleado.getCargos());

        // guardar el estudiante actualizado
        EmpleadosService.updateEmpleado(existentEmpleado);

        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String deleteEmpleado(@PathVariable Long id) {
        EmpleadosService.deleteEmpleadoById(id);
        return "redirect:/empleados";
    }

    @GetMapping("/cargos/{id}")
    public String deleteCargo(@PathVariable Long id) {
        CargosService.deleteCargoById(id);
        return "redirect:/cargos";
    }

}

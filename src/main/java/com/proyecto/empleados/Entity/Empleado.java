package com.proyecto.empleados.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // relacion muchos a muchos con cursos
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "empleados_cargos", joinColumns = {
            @JoinColumn(name = "empleado_id", referencedColumnName = "id", nullable = false, updatable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "cargo_id", referencedColumnName = "id", nullable = false, updatable = false)
    })

    private Set<Cargo> cargos = new HashSet<>();

    public Empleado() {
    }

    public Empleado(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }

    @Override
    public String toString() {
        return "Empleado{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }

}

package com.voll.api.medico;

import com.voll.api.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String documento;
    private String telefono;
    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded
    private Direccion direccion;

    public Medico(DataRegistroMedico body) {
        this.nombre = body.nombre();
        this.email = body.email();
        this.especialidad = body.especialidad();
        this.direccion = new Direccion(body.direccion());
        this.documento = body.documento();
        this.telefono = body.telefono();
        this.activo = true;
    }


    public Long getId() {
        return id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }


    public void actualizarMedico(DatosActualizarMedico datos) {
        if(datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if(datos.documento() != null) {
            this.documento = datos.documento();
        }
        if(datos.direccion() != null) {
            this.direccion = direccion.actualizarDatos(datos.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}

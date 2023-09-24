package com.voll.api.direccion;

import com.voll.api.medico.DatosActualizarMedico;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private Integer numero;
    private Integer codigo_postal;
    private String ciudad;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.codigo_postal = direccion.codigo_postal();
        this.ciudad = direccion.ciudad();
    }
    public Direccion actualizarDatos(DatosDireccion datos) {
        this.calle = datos.calle();
        this.numero = datos.numero();
        this.codigo_postal = datos.codigo_postal();
        this.ciudad = datos.ciudad();
        return this;
    }
}

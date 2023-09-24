package com.voll.api.medico;

import com.voll.api.direccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Integer id,
        String nombre,
        String documento,
        DatosDireccion direccion
) {
}

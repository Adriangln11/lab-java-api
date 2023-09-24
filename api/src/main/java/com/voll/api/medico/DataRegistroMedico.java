package com.voll.api.medico;

import com.voll.api.direccion.DatosDireccion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public record DataRegistroMedico(
        @NotBlank
        String nombre,
        @NotNull
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotBlank
        String telefono,
        @NotNull
        Especialidad especialidad,
        @NotBlank
        DatosDireccion direccion) {

}

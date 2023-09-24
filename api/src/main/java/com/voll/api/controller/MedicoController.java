package com.voll.api.controller;

import com.voll.api.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @PostMapping
    public void registrarMedico(@RequestBody @Valid DataRegistroMedico body) {

        repository.save(new Medico(body));
    }
    @GetMapping
    public Page<DatosListadoMedico> listarMedicos (Pageable paginacion) {
        return repository.findByActivoTrue(paginacion).map(DatosListadoMedico :: new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico (@RequestBody @Valid DatosActualizarMedico datos) {
        Medico medico = repository.getReferenceById(datos.id());
        medico.actualizarMedico(datos);

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico (@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id.intValue());
        medico.desactivarMedico();

    }

}

package com.manager.helpdesk.controller;

import com.manager.helpdesk.entities.Chamado;
import com.manager.helpdesk.repository.ChamadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoRepository repository;

    @GetMapping
    public List<Chamado> findAll() {
        return repository.findAll();
    };

    @GetMapping(value = "/{id}")
    public Chamado findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Chamado insert(@RequestBody Chamado chamado) {
        return repository.save(chamado);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

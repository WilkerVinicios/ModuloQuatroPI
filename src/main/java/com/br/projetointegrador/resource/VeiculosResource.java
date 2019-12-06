package com.br.projetointegrador.resource;

import com.br.projetointegrador.model.Veiculos;
import com.br.projetointegrador.repository.VeiculosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculosResource {

    @Autowired
    private VeiculosRepository veiculosRepository;

    @GetMapping
    public List<Veiculos> list() {
        return veiculosRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Veiculos> findById(@PathVariable Long id){
        return veiculosRepository.findById(id);
    }
    @PostMapping
    public ResponseEntity<Veiculos> create (@RequestBody Veiculos veiculos, HttpServletResponse response) {
        Veiculos save = veiculosRepository.save(veiculos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        veiculosRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Veiculos> update(@PathVariable Long id,@RequestBody Veiculos veiculos){
        Optional<Veiculos> veiculosBanco = veiculosRepository.findById(id);
        BeanUtils.copyProperties(veiculos, veiculosBanco.get());
        veiculosRepository.save(veiculosBanco.get());
        return ResponseEntity.ok(veiculos);
    }
}


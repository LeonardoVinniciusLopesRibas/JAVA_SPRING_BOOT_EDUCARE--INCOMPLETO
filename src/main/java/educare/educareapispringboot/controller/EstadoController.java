package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.Estado;
import educare.educareapispringboot.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/educare/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Estado> getEstado(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.getId(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Estado>> getEstados() {
        return ResponseEntity.ok(estadoService.getTudo());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Estado> cadastrarEstado(@RequestBody @Valid Estado estado, UriComponentsBuilder uriBuilder) {
        estadoService.cadastrarEstado(estado);
        URI uri = uriBuilder.path("/estado/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).body(estado);
    }
}

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
    public ResponseEntity<List<Estado>> cadastrarEstado(@RequestBody @Valid List<Estado> estados, UriComponentsBuilder uriBuilder) {
        List<Estado> estadosCadastrados = estadoService.cadastrarEstados(estados);

        URI uri = uriBuilder.path("/educare/estado/get").build().toUri();
        return ResponseEntity.created(uri).body(estadosCadastrados);
    }
}

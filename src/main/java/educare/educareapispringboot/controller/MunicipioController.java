package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.Municipio;
import educare.educareapispringboot.service.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/educare/municipio")
public class MunicipioController {

    @Autowired
    private MunicipioService municipioService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Municipio> getMunicipio(@PathVariable Long id) {
        return ResponseEntity.ok(municipioService.getId(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Municipio>> getMunicipios() {
        return ResponseEntity.ok(municipioService.getTudo());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Municipio> cadastrarMunicipio(@RequestBody @Valid Municipio municipio, UriComponentsBuilder uriBuilder) {
        municipioService.cadastrarMunicipio(municipio);
        URI uri = uriBuilder.path("/municipio/{id}").buildAndExpand(municipio.getId()).toUri();
        return ResponseEntity.created(uri).body(municipio);
    }
}

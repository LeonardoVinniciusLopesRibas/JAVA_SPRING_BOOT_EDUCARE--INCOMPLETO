package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.Regiao;
import educare.educareapispringboot.service.RegiaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/educare/regiao")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Regiao> getRegiaoId(@PathVariable Long id) {
        return ResponseEntity.ok(regiaoService.getId(id));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Regiao>> getRegiao() {
        return ResponseEntity.ok(regiaoService.getTudo());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Regiao> cadastrarRegiao(@RequestBody @Valid Regiao regiao, UriComponentsBuilder uriBuilder) {
        regiaoService.cadastrarRegiao(regiao);
        URI uri = uriBuilder.path("educare/regiao/get/{id}").buildAndExpand(regiao.getId()).toUri();
        return ResponseEntity.created(uri).body(regiao);
    }


}

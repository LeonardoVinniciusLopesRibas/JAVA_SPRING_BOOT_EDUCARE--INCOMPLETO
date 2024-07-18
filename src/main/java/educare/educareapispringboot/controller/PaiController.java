package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.service.PaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("/educare/pai")
public class PaiController {

    @Autowired
    private PaiService paiService;

    @GetMapping ("/get/{id}")
    public ResponseEntity<Pai> getPai(@PathVariable Long id) {
        return ResponseEntity.ok(paiService.getId(id));
    }


    @PostMapping("/cadastrar")
    public ResponseEntity<Pai> cadastrar(@RequestBody @Valid Pai pai, UriComponentsBuilder builder) {
        Pai existingPai = paiService.findByCpf(pai.getCpfPai());
        if (existingPai != null) {
            return ResponseEntity.badRequest().body(existingPai);
        }
        paiService.cadastrarPai(pai);
        URI uri = builder.path("/educare/pai/get/{id}").buildAndExpand(pai.getId()).toUri();
        return ResponseEntity.created(uri).body(pai);
    }

}

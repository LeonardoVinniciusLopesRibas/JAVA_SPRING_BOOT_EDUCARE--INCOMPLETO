package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.PaiDtoResponse;
import educare.educareapispringboot.exception.CpfDuplicado;
import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.service.PaiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
            throw new CpfDuplicado("Pai já cadastrado com esse CPF");
        }
        paiService.cadastrarPai(pai);
        URI uri = builder.path("/educare/pai/get/{id}").buildAndExpand(pai.getId()).toUri();
        return ResponseEntity.created(uri).body(pai);
    }

    @GetMapping("/get/pai")
    public ResponseEntity<List<PaiDtoResponse>> getPai(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, @RequestParam String endereco) {
        List<PaiDtoResponse> paiDtoResponseList = paiService.getPai(nome, cpf, telefone, endereco);
        if(paiDtoResponseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paiDtoResponseList);
    }

    @PutMapping("/put/desativar/{id}")
    public ResponseEntity<Pai> desativarPai(@PathVariable Long id) {
        return ResponseEntity.ok(paiService.desativar(id));
    }

    @GetMapping("/get/pai/desativados")
    public ResponseEntity<List<PaiDtoResponse>> getPaiDesativados(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, @RequestParam String endereco) {
        List<PaiDtoResponse> paiDtoResponseList = paiService.getPaiReativar(nome, cpf, telefone, endereco);
        if(paiDtoResponseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paiDtoResponseList);
    }
    @PutMapping("/put/reativar/{id}")
    public ResponseEntity<Pai> reativarPai(@PathVariable Long id) {
        return ResponseEntity.ok(paiService.reativarPai(id));
    }

}

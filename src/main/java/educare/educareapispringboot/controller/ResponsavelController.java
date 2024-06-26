package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.Responsavel;
import educare.educareapispringboot.service.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping("educare/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Responsavel> getId(@PathVariable Long id){
        return ResponseEntity.ok(responsavelService.getId(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Responsavel> cadastrar(@RequestBody @Valid Responsavel responsavel, UriComponentsBuilder builder){
        Responsavel existingResponsavel = responsavelService.findByCpf(responsavel.getCpfResponsavel());
        if (existingResponsavel != null){
            throw new RuntimeException("Identificado um responsável já cadastrado com esse cpf");
        }

        responsavelService.cadastrarResponsavel(responsavel);
        URI uri = builder.path("/educare/usuario/get/{id}").buildAndExpand(responsavel.getId()).toUri();
        return ResponseEntity.created(uri).body(responsavel);
    }


}

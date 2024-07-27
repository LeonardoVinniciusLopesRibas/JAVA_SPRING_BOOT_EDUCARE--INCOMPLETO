package educare.educareapispringboot.controller;

import educare.educareapispringboot.model.ValidacaoPreferencia;
import educare.educareapispringboot.service.ValidacaoPreferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("*")
@RequestMapping("/educare/validacao")
public class ValidacaoPreferenciaController {

    @Autowired
    private ValidacaoPreferenciaService vps;

    @GetMapping("/get/{id}")
    public ResponseEntity<ValidacaoPreferencia> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vps.getId(id));
    }

    @RequestMapping("/setTrue")
    public ResponseEntity<ValidacaoPreferencia> setTrue (ValidacaoPreferencia validacaoPreferencia, UriComponentsBuilder uriBuilder) {
        vps.setTrue(validacaoPreferencia);
        URI uri = uriBuilder.path("/educare/validacao/get/{id}").buildAndExpand(validacaoPreferencia.getId()).toUri();
        return ResponseEntity.created(uri).body(validacaoPreferencia);
    }

    @RequestMapping("/checkSetTrue")
    public ResponseEntity<Boolean> check (){
        return ResponseEntity.ok(vps.check());
    }


}

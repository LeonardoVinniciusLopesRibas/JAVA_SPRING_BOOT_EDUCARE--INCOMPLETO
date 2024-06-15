package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.UsuarioRequestValidation;
import educare.educareapispringboot.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/educare/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/validacao")
    public ResponseEntity<Boolean> validaUsuario(@RequestBody @Valid UsuarioRequestValidation urv){
        return ResponseEntity.ok(usuarioService.validaUsuario(urv));
    }


}

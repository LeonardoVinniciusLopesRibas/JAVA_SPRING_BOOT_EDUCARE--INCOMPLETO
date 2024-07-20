package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.UsuarioRequestValidation;
import educare.educareapispringboot.exception.UsuarioDuplicadoException;
import educare.educareapispringboot.model.Usuario;
import educare.educareapispringboot.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RestController
@RequestMapping("/educare/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody @Valid UsuarioRequestValidation urv) {
        Usuario usuario = usuarioService.validaUsuario(urv);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getId(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder builder){
        Usuario existingUser = usuarioService.findByEmail(usuario.getUsuario());
        if(existingUser != null){
            throw new UsuarioDuplicadoException("Usuário já cadastrado com este nome.");
        }
        usuarioService.cadastrarUsuario(usuario);
        URI uri = builder.path("/educare/usuario/get/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }


}

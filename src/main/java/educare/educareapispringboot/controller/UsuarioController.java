package educare.educareapispringboot.controller;

import educare.educareapispringboot.dto.UsuarioRequestValidation;
import educare.educareapispringboot.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/educare/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    private Map<String, HttpSession> sessionMap = new HashMap<>();

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(HttpSession session, @RequestBody UsuarioRequestValidation urv) {
        Boolean isAuthenticated = usuarioService.validaUsuario(urv);

        if (isAuthenticated) {
            session.setAttribute("user", urv.getEmail());
            sessionMap.put(session.getId(), session);
        }

        return ResponseEntity.ok(isAuthenticated);
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        // Remover a sessão do usuário ao fazer logout
        session.invalidate();
        sessionMap.remove(session.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/session")
    public ResponseEntity<Boolean> checkSession(HttpSession session) {
        // Verificar se o usuário possui uma sessão válida
        Boolean isLoggedIn = session.getAttribute("user") != null;
        return ResponseEntity.ok(isLoggedIn);
    }

    // Endpoint para validar se o usuário tem permissão para acessar uma página protegida
    @GetMapping("/valida-permissao")
    public ResponseEntity<Boolean> validaPermissao(HttpSession session) {
        Boolean isLoggedIn = session.getAttribute("user") != null;
        return ResponseEntity.ok(isLoggedIn);
    }

    // Endpoint para encerrar todas as sessões ativas (opcional)
    @GetMapping("/encerrar-sessoes")
    public ResponseEntity<Void> encerrarTodasSessoes() {
        sessionMap.values().forEach(HttpSession::invalidate);
        sessionMap.clear();
        return ResponseEntity.noContent().build();
    }
}

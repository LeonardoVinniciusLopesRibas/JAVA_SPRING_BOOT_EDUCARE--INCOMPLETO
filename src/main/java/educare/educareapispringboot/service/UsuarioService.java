package educare.educareapispringboot.service;

import educare.educareapispringboot.dto.UsuarioRequestValidation;
import educare.educareapispringboot.model.Usuario;
import educare.educareapispringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario validaUsuario(UsuarioRequestValidation urv) {
        return usuarioRepository.findByEmailAndSenhaAndAtivoTrue(urv.getEmail(), urv.getSenha());
    }

    public Usuario getId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElse(null);

    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        usuario.setAtivo(true);
        return usuarioRepository.save(usuario);
    }


    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}

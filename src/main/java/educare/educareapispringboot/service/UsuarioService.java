package educare.educareapispringboot.service;

import educare.educareapispringboot.dto.UsuarioRequestValidation;
import educare.educareapispringboot.model.Usuario;
import educare.educareapispringboot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Boolean validaUsuario(UsuarioRequestValidation urv) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(urv.getEmail(), urv.getSenha());
        return usuario != null;
    }
}

package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsuarioAndSenhaAndAtivoTrue(String email, String senha);

    Usuario findByUsuario(String email);
}

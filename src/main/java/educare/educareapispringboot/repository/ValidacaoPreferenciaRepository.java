package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.ValidacaoPreferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidacaoPreferenciaRepository extends JpaRepository<ValidacaoPreferencia, Long> {
}

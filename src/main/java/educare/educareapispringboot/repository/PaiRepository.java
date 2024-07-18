package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Pai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiRepository extends JpaRepository<Pai, Long> {

    Pai findByCpfPai(String cpf);
}

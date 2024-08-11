package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Pai;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiRepository extends JpaRepository<Pai, Long> {

    Pai findByCpfPai(String cpf);

    List<Pai> findAllByAtivoIsTrue(Sort sort);

    List<Pai> findAllByAtivoIsFalse(Sort sort);
}

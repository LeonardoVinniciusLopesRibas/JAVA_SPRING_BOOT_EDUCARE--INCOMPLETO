package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    Responsavel findByCpf(String cpfResponsavel);
}

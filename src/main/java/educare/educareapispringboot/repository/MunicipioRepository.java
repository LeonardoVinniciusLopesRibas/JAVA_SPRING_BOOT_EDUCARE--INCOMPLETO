package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Municipio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    List<Municipio> findByUf(String uf_estado, Sort sort);

}

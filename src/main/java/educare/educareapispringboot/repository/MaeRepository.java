package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Mae;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaeRepository extends JpaRepository<Mae, Long> {

    List<Mae> findAllByAtivoIsTrue(Sort sort);



}

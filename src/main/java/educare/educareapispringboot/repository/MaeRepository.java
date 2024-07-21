package educare.educareapispringboot.repository;

import educare.educareapispringboot.model.Mae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaeRepository extends JpaRepository<Mae, Long> {



}

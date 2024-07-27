package educare.educareapispringboot.service;

import educare.educareapispringboot.model.ValidacaoPreferencia;
import educare.educareapispringboot.repository.ValidacaoPreferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidacaoPreferenciaService {

    @Autowired
    private ValidacaoPreferenciaRepository validacaoPreferenciaRepository;

    public ValidacaoPreferencia getId(Long id) {

        Optional<ValidacaoPreferencia> optional = validacaoPreferenciaRepository.findById(id);
        return optional.orElse(null);

    }

    public ValidacaoPreferencia setTrue(ValidacaoPreferencia validacaoPreferencia) {
        validacaoPreferenciaRepository.save(validacaoPreferencia);
        return validacaoPreferencia;
    }

    public Boolean check() {
        return validacaoPreferenciaRepository.existsById(1L);
    }
}

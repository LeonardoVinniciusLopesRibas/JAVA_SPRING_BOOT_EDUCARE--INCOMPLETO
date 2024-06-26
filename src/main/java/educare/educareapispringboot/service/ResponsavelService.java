package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Responsavel;
import educare.educareapispringboot.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    public Responsavel getId(Long id) {
        Optional<Responsavel> responsavelOptional = responsavelRepository.findById(id);
        return responsavelOptional.orElse(null);
    }

    public Responsavel findByCpf(String cpfResponsavel) {
        return responsavelRepository.findByCpf(cpfResponsavel);
    }

    public Responsavel cadastrarResponsavel(Responsavel responsavel) {
        responsavel.setAtivo(true);
        return responsavelRepository.save(responsavel);
    }
}

package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Municipio;
import educare.educareapispringboot.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public Municipio getId(Long id) {
        Optional<Municipio> municipio = municipioRepository.findById(id);
        return municipio.orElse(null);
    }

    public List<Municipio> cadastrarMunicipios(List<Municipio> municipio) {
        return municipioRepository.saveAll(municipio);
    }

    public List<Municipio> getTudo() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return municipioRepository.findAll(sort);
    }
}

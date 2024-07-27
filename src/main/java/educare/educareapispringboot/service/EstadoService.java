package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Estado;
import educare.educareapispringboot.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado getId(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.orElse(null);
    }

    public Estado cadastrarEstado(Estado estado) {
        estadoRepository.save(estado);
        return estado;
    }

    public List<Estado> getTudo() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return estadoRepository.findAll(sort);
    }
}

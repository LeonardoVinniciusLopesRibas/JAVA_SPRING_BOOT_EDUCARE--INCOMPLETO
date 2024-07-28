package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Estado;
import educare.educareapispringboot.model.Regiao;
import educare.educareapispringboot.repository.EstadoRepository;
import educare.educareapispringboot.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private RegiaoRepository regiaoRepository;

    public Estado getId(Long id) {
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.orElse(null);
    }

    public List<Estado> cadastrarEstados(List<Estado> estados) {
        for (Estado estado : estados) {
            Optional<Regiao> regiao = regiaoRepository.findById(estado.getRegiao().getId());
            regiao.ifPresent(estado::setRegiao);
        }
        return estadoRepository.saveAll(estados);
    }

    public List<Estado> getTudo() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return estadoRepository.findAll(sort);
    }
}

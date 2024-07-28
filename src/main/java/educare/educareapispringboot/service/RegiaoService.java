package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Regiao;
import educare.educareapispringboot.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public Regiao getId(Long id) {
        Optional<Regiao> regiao = regiaoRepository.findById(id);
        return regiao.orElse(null);
    }

    public List<Regiao> cadastrarRegioes(List<Regiao> regioes) {
        return regiaoRepository.saveAll(regioes);
    }

    public List<Regiao> getTudo() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return regiaoRepository.findAll();
    }
}

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

    public Regiao cadastrarRegiao(Regiao regiao) {
        regiaoRepository.save(regiao);
        return regiao;
    }

    public List<Regiao> getTudo() {
        Sort sort = Sort.by(Sort.Direction.ASC, "nome");
        return regiaoRepository.findAll();
    }
}

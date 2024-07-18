package educare.educareapispringboot.service;

import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.repository.PaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaiService {

    @Autowired
    private PaiRepository paiRepository;

    public Pai getId(Long id){
        Optional<Pai> paiOptional = paiRepository.findById(id);
        return paiOptional.orElse(null);
    }

    public Pai findByCpf(String cpfPai) {
        return paiRepository.findByCpfPai(cpfPai);
    }

    public Pai cadastrarPai(Pai pai) {
        pai.setAtivo(true);
        return paiRepository.save(pai);
    }
}

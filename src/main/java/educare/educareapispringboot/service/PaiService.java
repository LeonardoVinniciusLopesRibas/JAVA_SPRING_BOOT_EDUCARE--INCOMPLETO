package educare.educareapispringboot.service;

import educare.educareapispringboot.dto.PaiDtoResponseTable;
import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.repository.PaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PaiDtoResponseTable> getPai(String nome, String cpf, String telefone, String endereco) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nomeCompletoPai");

        List<Pai> pais = paiRepository.findAllByAtivoIsTrue(sort);

        String nomeLowerCase = nome != null ? nome.toLowerCase() : null;
        String cpfLowerCase = cpf != null ? cpf.toLowerCase() : null;
        String telefoneLowerCase = telefone != null ? telefone.toLowerCase() : null;
        String enderecoLowerCase = endereco != null ? endereco.toLowerCase() : null;

        return pais.stream()
                .filter(pai -> {
                    boolean matches = (nomeLowerCase == null || pai.getNomeCompletoPai().toLowerCase().contains(nomeLowerCase)) &&
                            (cpfLowerCase == null || pai.getCpfPai().toLowerCase().contains(cpfLowerCase)) &&
                            (telefoneLowerCase == null || pai.getTelefonePai().toLowerCase().contains(telefoneLowerCase)) &&
                            (enderecoLowerCase == null || pai.getLogradouro().toLowerCase().contains(enderecoLowerCase));
                    return matches;
                })
                .map(pai -> new PaiDtoResponseTable(
                        pai.getId(),
                        pai.getNomeCompletoPai(),
                        pai.getCpfPai(),
                        pai.getTelefonePai(),
                        pai.getLogradouro(),
                        pai.getLocalidade(),
                        pai.getUf()
                ))
                .collect(Collectors.toList());
    }

    public Pai desativar(Long id) {
        Pai pai = getId(id);
        pai.setAtivo(false);
        return paiRepository.save(pai);
    }

    public List<PaiDtoResponseTable> getPaiReativar(String nome, String cpf, String telefone, String endereco) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nomeCompletoPai");

        List<Pai> pais = paiRepository.findAllByAtivoIsFalse(sort);

        String nomeLowerCase = nome != null ? nome.toLowerCase() : null;
        String cpfLowerCase = cpf != null ? cpf.toLowerCase() : null;
        String telefoneLowerCase = telefone != null ? telefone.toLowerCase() : null;
        String enderecoLowerCase = endereco != null ? endereco.toLowerCase() : null;

        return pais.stream()
                .filter(pai -> {
                    boolean matches = (nomeLowerCase == null || pai.getNomeCompletoPai().toLowerCase().contains(nomeLowerCase)) &&
                            (cpfLowerCase == null || pai.getCpfPai().toLowerCase().contains(cpfLowerCase)) &&
                            (telefoneLowerCase == null || pai.getTelefonePai().toLowerCase().contains(telefoneLowerCase)) &&
                            (enderecoLowerCase == null || pai.getLogradouro().toLowerCase().contains(enderecoLowerCase));
                    return matches;
                })
                .map(pai -> new PaiDtoResponseTable(
                        pai.getId(),
                        pai.getNomeCompletoPai(),
                        pai.getCpfPai(),
                        pai.getTelefonePai(),
                        pai.getLogradouro(),
                        pai.getLocalidade(),
                        pai.getUf()
                ))
                .collect(Collectors.toList());
    }

    public Pai reativarPai(Long id) {
        Pai pai = getId(id);
        pai.setAtivo(true);
        return paiRepository.save(pai);
    }

    public Pai putPai(Pai pai) {
        return paiRepository.save(pai);
    }
}

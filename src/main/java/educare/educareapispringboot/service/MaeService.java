package educare.educareapispringboot.service;

import educare.educareapispringboot.dto.MaeDtoResponse;
import educare.educareapispringboot.dto.MaeDtoResponseTable;
import educare.educareapispringboot.model.Mae;
import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.repository.MaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaeService {

    @Autowired
    private MaeRepository maeRepository;

    public List<MaeDtoResponse> buscaMae(String query) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nomeCompletoMae");
        List<Mae> allMaes = maeRepository.findAllByAtivoIsTrue(sort);
        String lowerCaseQuery = query.toLowerCase();

        return allMaes.stream()
                .filter(mae -> {
                    boolean matches = mae.getNomeCompletoMae().toLowerCase().contains(lowerCaseQuery) ||
                            mae.getCpfMae().contains(query) ||
                            mae.getCep().contains(query);
                    return matches;
                })
                .map(mae -> new MaeDtoResponse(
                        mae.getId(),
                        mae.getNomeCompletoMae(),
                        mae.getCpfMae(),
                        mae.getCep(),
                        mae.getLogradouro(),
                        mae.getNumero(),
                        mae.getBairro(),
                        mae.getComplemento(),
                        mae.getLocalidade(),
                        mae.getUf(),
                        mae.getIbge()
                ))
                .collect(Collectors.toList());
    }

    public MaeDtoResponse getMaeById(Long id) {
        Optional<Mae> maeOptional = maeRepository.findById(id);

        if (maeOptional.isPresent()) {
            Mae mae = maeOptional.get();
            MaeDtoResponse maeDtoResponse = convertendoMaeToDto(mae);
            return maeDtoResponse;
        } else {
            return null;
        }
    }

    private MaeDtoResponse convertendoMaeToDto(Mae mae) {
        MaeDtoResponse dto = new MaeDtoResponse();
        dto.setId(mae.getId());
        dto.setNomeCompletoMae(mae.getNomeCompletoMae());
        dto.setCpfMae(mae.getCpfMae());
        dto.setCep(mae.getCep());
        dto.setLogradouro(mae.getLogradouro());
        dto.setNumero(mae.getNumero());
        dto.setBairro(mae.getBairro());
        dto.setComplemento(mae.getComplemento());
        dto.setLocalidade(mae.getLocalidade());
        dto.setUf(mae.getUf());
        dto.setIbge(mae.getIbge());
        return dto;
    }

    public Mae getById(Long id) {
        Optional<Mae> mae = maeRepository.findById(id);
        return mae.orElse(null);
    }

    public List<MaeDtoResponseTable> getMae(String nome, String cpf, String telefone, String endereco) {
        Sort sort = Sort.by(Sort.Direction.ASC, "nomeCompletoMae");

        List<Mae> maes = maeRepository.findAllByAtivoIsTrue(sort);

        String nomeLowerCase = nome != null ? nome.toLowerCase() : null;
        String cpfLowerCase = cpf != null ? cpf.toLowerCase() : null;
        String telefoneLowerCase = telefone != null ? telefone.toLowerCase() : null;
        String enderecoLowerCase = endereco != null ? endereco.toLowerCase() : null;

        return maes.stream()
                .filter(mae -> {
                    boolean matches = (nomeLowerCase == null || mae.getNomeCompletoMae().toLowerCase().contains(nomeLowerCase)) &&
                            (cpfLowerCase == null || mae.getCpfMae().toLowerCase().contains(cpfLowerCase)) &&
                            (telefoneLowerCase == null || mae.getTelefoneMae().toLowerCase().contains(telefoneLowerCase)) &&
                            (enderecoLowerCase == null || mae.getLogradouro().toLowerCase().contains(enderecoLowerCase));
                    return matches;
                })
                .map(mae -> new MaeDtoResponseTable(
                        mae.getId(),
                        mae.getNomeCompletoMae(),
                        mae.getCpfMae(),
                        mae.getTelefoneMae(),
                        mae.getLogradouro(),
                        mae.getLocalidade(),
                        mae.getUf()
                ))
                .collect(Collectors.toList());
    }
}
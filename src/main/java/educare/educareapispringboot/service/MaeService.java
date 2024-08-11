package educare.educareapispringboot.service;

import educare.educareapispringboot.dto.MaeDtoResponse;
import educare.educareapispringboot.model.Mae;
import educare.educareapispringboot.model.Pai;
import educare.educareapispringboot.repository.MaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Mae> allMaes = maeRepository.findAllByAtivoIsTrue();
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

}
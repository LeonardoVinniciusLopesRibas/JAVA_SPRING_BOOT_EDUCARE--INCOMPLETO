package educare.educareapispringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaiDtoResponseTable {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String logradouro;
    private String nomeCidade;
    private String nomeEstado;

}

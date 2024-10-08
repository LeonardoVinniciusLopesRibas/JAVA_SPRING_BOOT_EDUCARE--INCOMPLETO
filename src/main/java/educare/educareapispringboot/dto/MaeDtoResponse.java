package educare.educareapispringboot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaeDtoResponse {

    private Long id;
    private String nomeCompletoMae;
    private String cpfMae;
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String ibge;
}

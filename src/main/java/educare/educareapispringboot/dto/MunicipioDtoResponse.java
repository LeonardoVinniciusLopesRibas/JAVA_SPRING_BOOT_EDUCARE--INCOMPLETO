package educare.educareapispringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MunicipioDtoResponse {

    private Long id;

    @NotBlank(message = "O nome do município não pode ser vazio")
    @Size(max = 100, message = "O nome do município não pode ter mais de 100 caracteres")
    private String nome;

    private String uf;
}

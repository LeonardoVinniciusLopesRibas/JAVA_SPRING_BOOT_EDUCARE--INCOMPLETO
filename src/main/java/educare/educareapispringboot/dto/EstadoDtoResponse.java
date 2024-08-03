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
public class EstadoDtoResponse {

    private Long id;

    @NotBlank(message = "A sigla UF não pode ser vazia")
    @Size(max = 2, message = "A sigla UF não pode ter mais de 2 caracteres")
    private String siglaUf;

}

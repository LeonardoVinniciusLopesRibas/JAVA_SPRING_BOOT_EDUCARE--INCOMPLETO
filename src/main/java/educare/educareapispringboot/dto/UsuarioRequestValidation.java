package educare.educareapispringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestValidation {

    @Email(message = "Email não é válido")
    @NotNull(message = "Email não pode ficar vazio")
    @NotEmpty(message = "Email não pode ficar em branco")
    @NotBlank(message = "Email não pode ficar em branco")
    private String email;

    @NotNull(message = "Senha não pode ficar vazio")
    @NotEmpty(message = "Senha não pode ficar em branco")
    @NotBlank(message = "Senha não pode ficar em branco")
    private String senha;

}

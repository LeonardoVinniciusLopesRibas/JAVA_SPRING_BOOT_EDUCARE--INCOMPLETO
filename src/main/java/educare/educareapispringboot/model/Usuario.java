package educare.educareapispringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Nome não pode ficar vazio")
    @NotEmpty(message = "Nome não pode ficar em branco")
    @NotBlank(message = "Nome não pode ficar em branco")
    @Size(min = 3, max = 100, message = "Nome deverá ter entre 3 e 100 caracteres")
    @Column(length = 100)
    private String nome;

    @Email(message = "Email não é válido")
    @NotNull(message = "Email não pode ficar vazio")
    @NotEmpty(message = "Email não pode ficar em branco")
    @NotBlank(message = "Email não pode ficar em branco")
    @Column(length = 100)
    private String email;

    @Column(length = 1000)
    @NotNull(message = "Senha não pode ficar vazio")
    @NotEmpty(message = "Senha não pode ficar em branco")
    @NotBlank(message = "Senha não pode ficar em branco")
    private String senha;

}
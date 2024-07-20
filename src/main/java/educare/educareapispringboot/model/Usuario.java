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

    @NotNull(message = "NOME DO USUÁRIO NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO USUÁRIO PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO USUÁRIO NÃO PODE FICAR EM BRANCO")
    @Size(min = 2, max = 100, message = "NOME DO USUÁRIO DEVE TER ENTRE 2 E 100 CARACTERES")
    @Column(length = 100)
    private String nome;

    @NotNull(message = "USUÁRIO NÃO PODE FICAR NULO")
    @NotEmpty(message = "USUÁRIO PRECISA SER PREENCHIDO")
    @NotBlank(message = "USUÁRIO NÃO PODE FICAR EM BRANCO")
    @Column(length = 100, unique = true)
    private String usuario;

    @Column(length = 1000)
    @NotNull(message = "SENHA NÃO PODE FICAR NULO")
    @NotEmpty(message = "SENHA PRECISA SER PREENCHIDO")
    @NotBlank(message = "SENHA NÃO PODE FICAR EM BRANCO")
    private String senha;

    @NotNull(message = "ATIVO NÃO PODE FICAR VAZIO")
    private boolean ativo;

}
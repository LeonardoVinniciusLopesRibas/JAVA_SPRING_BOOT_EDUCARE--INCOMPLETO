package educare.educareapispringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pessoaReserva")
public class PessoaReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME DA PESSOA RESERVA DA CRIANÇA É OBRIGATÓRIO")
    @NotEmpty(message = "NOME DA PESSOA RESERVA DE ANIVERSÁRIO DA CRIANÇA DEVE SER PREENCHIDO")
    @NotBlank(message = "NOME DA PESSOA RESERVA DE ANIVERSÁRIO DA CRIANÇA DEVE SER PREENCHIDO")
    private String nomeCompletoPessoa;

    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DA PESSOA RESERVA DEVE CONTER 11 CARACTERES")
    @NotNull(message = "TELEFONE DA PESSOA RESERVA NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DA PESSOA RESERVA PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DA PESSOA RESERVA NÃO PODE FICAR EM BRANCO")
    private String telefone;

    @NotNull(message = "ATIVO NÃO PODE FICAR VAZIO")
    private boolean ativo;
}

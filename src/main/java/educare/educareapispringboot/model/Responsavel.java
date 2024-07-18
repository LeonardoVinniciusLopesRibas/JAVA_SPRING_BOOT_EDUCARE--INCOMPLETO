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
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "responsavel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Responsavel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME DO RESPONSÁVEL NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO RESPONSÁVEL PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO RESPONSÁVEL NÃO PODE FICAR EM BRANCO")
    @Size(min = 3, max = 100, message = "NOME DO RESPONSÁVEL DEVE TER ENTRE 3 E 100 CARACTERES")
    @Column(length = 100)
    private String nomeCompletoResponsavel;

    @Size(min = 11, max = 11, message = "CPF DO RESPONSÁVEL DEVE CONTER 11 CARACTERES OU FICAR VAZIO")
    @Column(length = 11, unique = true)
    @CPF
    private String cpfResponsavel;

    @NotNull(message = "TELEFONE DO RESPONSÁVEL NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO RESPONSÁVEL PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO RESPONSÁVEL NÃO PODE FICAR EM BRANCO")
    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DO RESPONSÁVEL DEVE CONTER 11 CARACTERES")
    private String telefoneResponsavel;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefoneResponsavelWhatsapp;

    @NotNull(message = "NOME DO CONTATO RESERVA DO RESPONSÁVEL NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO CONTATO RESERVA DO RESPONSÁVEL PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO CONTATO RESERVA DO RESPONSÁVEL NÃO PODE FICAR EM BRANCO")
    @Column(length = 100)
    @Size(min = 3, max = 100, message = "NOME DO CONTATO RESERVA DO RESPONSÁVEL DEVE TER ENTRE 3 E 100 CARACTERES")
    private String contatoReserva;

    @NotNull(message = "MARQUE SE PODE BUSCAR A CRIANÇA")
    private boolean podeBuscar;

    @NotNull(message = "TELEFONE DO CONTATO RESERVA DO RESPONSÁVEL NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO CONTATO RESERVA DO RESPONSÁVEL PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO CONTATO RESERVA DO RESPONSÁVEL NÃO PODE FICAR EM BRANCO")
    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DO CONTATO RESERVA DO RESPONSÁVEL DEVE CONTER 11 CARACTERES")
    private String telefoneReserva;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefoneReservaWhatsapp;

    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String numero;
    private String siafi;

    @NotNull(message = "ATIVO NÃO PODE FICAR VAZIO")
    private boolean ativo;


}

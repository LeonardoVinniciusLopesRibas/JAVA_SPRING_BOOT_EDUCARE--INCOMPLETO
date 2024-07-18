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

@Table(name = "pai")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO PAI NÃO PODE FICAR EM BRANCO")
    @Size(min = 3, max = 100, message = "NOME DO PAI DEVE TER ENTRE 3 E 100 CARACTERES")
    @Column(length = 100)
    private String nomeCompletoPai;

    @Size(min = 11, max = 11, message = "CPF DO PAI DEVE CONTER 11 CARACTERES OU FICAR VAZIO")
    @Column(length = 11, unique = true)
    @CPF
    private String cpfPai;

    @NotNull(message = "TELEFONE DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO PAI NÃO PODE FICAR EM BRANCO")
    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DO PAI DEVE CONTER 11 CARACTERES")
    private String telefonePai;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefonePaiWhatsapp;

    @NotNull(message = "NOME DO CONTATO RESERVA DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO CONTATO RESERVA DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO CONTATO RESERVA DO PAI NÃO PODE FICAR EM BRANCO")
    @Column(length = 100)
    @Size(min = 3, max = 100, message = "NOME DO CONTATO RESERVA DO PAI DEVE TER ENTRE 3 E 100 CARACTERES")
    private String contatoReserva;

    @NotNull(message = "MARQUE SE PODE BUSCAR A CRIANÇA")
    private boolean podeBuscar;

    @NotNull(message = "TELEFONE DO CONTATO RESERVA DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO CONTATO RESERVA DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO CONTATO RESERVA DO PAI NÃO PODE FICAR EM BRANCO")
    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DO CONTATO RESERVA DO PAI DEVE CONTER 11 CARACTERES")
    private String telefoneReserva;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefoneReservaWhatsapp;

    @OneToOne
    @JoinColumn(name = "mae_id")
    private Mae mae;

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

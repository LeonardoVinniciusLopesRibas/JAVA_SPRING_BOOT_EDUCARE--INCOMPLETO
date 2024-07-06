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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mae")
public class Mae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME DA MÃE NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DA MÃE PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DA MÃE NÃO PODE FICAR EM BRANCO")
    @Size(min = 3, max = 100, message = "NOME DA MÃE DEVE TER ENTRE 3 E 100 CARACTERES")
    @Column(length = 100)
    private String nomeCompletoMae;

    @Size(min = 11, max = 11, message = "CPF DA MÃE DEVE CONTER 11 CARACTERES OU FICAR VAZIO")
    @Column(length = 11, unique = true)
    @CPF
    private String cpfMae;

    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DA MÃE DEVE CONTER 11 CARACTERES")
    @NotNull(message = "TELEFONE DA MÃE NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DA MÃE PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DA MÃE NÃO PODE FICAR EM BRANCO")
    private String telefoneMae;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefoneMaeWhatsapp;

    @NotNull(message = "NOME DO CONTATO RESERVA DA MÃE NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO CONTATO RESERVA DA MÃE PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO CONTATO RESERVA DA MÃE NÃO PODE FICAR EM BRANCO")
    @Column(length = 100)
    @Size(min = 3, max = 100, message = "NOME DO CONTATO RESERVA DA MÃE DEVE TER ENTRE 3 E 100 CARACTERES")
    private String contatoReserva;

    @NotNull(message = "MARQUE SE PODE BUSCAR A CRIANÇA")
    private boolean podeBuscar;

    @NotNull(message = "TELEFONE DO CONTATO RESERVA DA MÃE NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO CONTATO RESERVA DA MÃE PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO CONTATO RESERVA DA MÃE NÃO PODE FICAR EM BRANCO")
    @Column(length = 11)
    @Size(min = 11, max = 11, message = "TELEFONE DO CONTATO RESERVA DA MÃE DEVE CONTER 11 CARACTERES")
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

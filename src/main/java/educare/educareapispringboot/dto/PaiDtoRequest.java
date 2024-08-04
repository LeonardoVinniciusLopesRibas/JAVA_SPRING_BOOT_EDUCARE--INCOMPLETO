package educare.educareapispringboot.dto;

import educare.educareapispringboot.model.Mae;
import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
public class PaiDtoRequest {

    @NotNull(message = "NOME DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO PAI NÃO PODE FICAR EM BRANCO")
    @Size(min = 3, max = 100, message = "NOME DO PAI DEVE TER ENTRE 3 E 100 CARACTERES")
    private String nomeCompletoPai;

    @CPF
    @Size(min = 11, max = 11, message = "CPF DO PAI DEVE CONTER 11 CARACTERES OU FICAR VAZIO")
    private String cpfPai;

    @NotNull(message = "TELEFONE DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO PAI NÃO PODE FICAR EM BRANCO")
    @Size(min = 10, max = 11, message = "TELEFONE DO PAI DEVE CONTER 11 CARACTERES")
    private String telefonePai;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefonePaiWhatsapp;

    @NotNull(message = "NOME DO CONTATO RESERVA DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "NOME DO CONTATO RESERVA DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "NOME DO CONTATO RESERVA DO PAI NÃO PODE FICAR EM BRANCO")
    @Size(min = 3, max = 100, message = "NOME DO CONTATO RESERVA DO PAI DEVE TER ENTRE 3 E 100 CARACTERES")
    private String contatoReserva;

    @NotNull(message = "MARQUE SE PODE BUSCAR A CRIANÇA")
    private boolean podeBuscar;

    @NotNull(message = "TELEFONE DO CONTATO RESERVA DO PAI NÃO PODE FICAR NULO")
    @NotEmpty(message = "TELEFONE DO CONTATO RESERVA DO PAI PRECISA SER PREENCHIDO")
    @NotBlank(message = "TELEFONE DO CONTATO RESERVA DO PAI NÃO PODE FICAR EM BRANCO")
    @Size(min = 10, max = 11, message = "TELEFONE DO CONTATO RESERVA DO PAI DEVE CONTER 11 CARACTERES")
    private String telefoneReserva;

    @NotNull(message = "MARQUE SE É WHATSAPP OU NÃO")
    private boolean telefoneReservaWhatsapp;

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String numero;

    private Mae mae;

    @NotNull(message = "ATIVO NÃO PODE FICAR VAZIO")
    private boolean ativo;
}

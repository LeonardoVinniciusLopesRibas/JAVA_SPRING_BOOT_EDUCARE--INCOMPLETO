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

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "crianca")
@Entity
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "NOME DA CRIANÇA É OBRIGATÓRIO")
    @NotEmpty(message = "NOME DA CRIANÇA DEVE SER PREENCHIDO")
    @NotBlank(message = "NOME DA CRIANÇA DEVE SER PREENCHIDO")
    @Size(min = 2, max = 100, message = "NOME DA CRIANÇA DEVE TER ENTRE 2 E 100 CARACTERES")
    @Column(length = 100)
    private String nome;
    private Pai pai;
   // private Mae mae;

    private Responsavel responsavel;

    private boolean restricaoAlimentarTrue;

    @Size(max = 200, message = "RESTRIÇÃO ALIMENTAR DEVE POSSUIR NO MÁXIMO 200 CARACTERES")
    @Column(length = 200)
    private String restricaoAlimentar;
    private boolean alergiaTrue;

    @Size(max = 200, message = "ALERGIA DEVE POSSUIR NO MÁXIMO 200 CARACTERES")
    @Column(length = 200)
    private String alergia;
    private boolean cirurgiaTrue;

    @Size(max = 200, message = "CIRURGIA DEVE POSSUIR NO MÁXIMO 200 CARACTERES")
    @Column(length = 200)
    private String cirurgia;

    @NotNull(message = "DATA DE NASCIMENTO DA CRIANÇA É OBRIGATÓRIO")
    @NotEmpty(message = "DATA DE NASCIMENTO DA CRIANÇA DEVE SER PREENCHIDO")
    @NotBlank(message = "DATA DE NASCIMENTO DA CRIANÇA DEVE SER PREENCHIDO")
    private LocalDate dataNascimento;

    @NotNull(message = "ATIVO NÃO PODE FICAR VAZIO")
    private boolean ativo;




}

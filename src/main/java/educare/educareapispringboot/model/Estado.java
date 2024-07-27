package educare.educareapispringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "O código UF não pode ser vazio")
    @Size(max = 10, message = "O código UF não pode ter mais de 10 caracteres")
    private String codigoUf;

    @Column(unique = true)
    @NotBlank(message = "O nome UF não pode ser vazio")
    @Size(max = 100, message = "O nome UF não pode ter mais de 100 caracteres")
    private String nomeUf;

    @Column(unique = true)
    @NotBlank(message = "A sigla UF não pode ser vazia")
    @Size(max = 2, message = "A sigla UF não pode ter mais de 2 caracteres")
    private String siglaUf;

    @ManyToOne
    @JoinColumn(name = "regiao_id", nullable = false)
    @NotNull(message = "A região não pode ser nula")
    private Regiao regiao;

}

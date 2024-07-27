package educare.educareapispringboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "O código IBGE não pode ser vazio")
    @Size(min = 7, max = 7, message = "O código IBGE deve ter exatamente 7 caracteres")
    @Pattern(regexp = "\\d{7}", message = "O código IBGE deve conter apenas dígitos")
    private String ibge;

    @NotBlank(message = "O nome do município não pode ser vazio")
    @Size(max = 100, message = "O nome do município não pode ter mais de 100 caracteres")
    private String nome;

    @NotNull(message = "A uf do estado não pode ser nulo")
    private String uf_estado;




}

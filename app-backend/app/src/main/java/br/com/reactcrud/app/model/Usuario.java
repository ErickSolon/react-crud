package br.com.reactcrud.app.model;

import br.com.reactcrud.app.model.dto.UsuarioDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    public UsuarioDTO toDTO() {
        return UsuarioDTO.builder()
                .id(id)
                .nome(nome)
                .sobrenome(sobrenome)
                .build();
    }
}

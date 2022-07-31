package br.com.reactcrud.app.model.dto;

import br.com.reactcrud.app.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    public Long id;

    @NotBlank(message = "Nome é obrigatório")
    public String nome;

    @NotBlank(message = "Sobrenome é obrigatório")
    public String sobrenome;

    public Usuario toEntity() {
        return Usuario.builder()
                .id(id)
                .nome(nome)
                .sobrenome(sobrenome)
                .build();
    }
}

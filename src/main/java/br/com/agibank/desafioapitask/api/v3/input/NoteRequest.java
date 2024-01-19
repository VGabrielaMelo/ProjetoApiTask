package br.com.agibank.desafioapitask.api.v3.input;

import br.com.agibank.desafioapitask.enuns.CorNote;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteRequest {

    private CorNote cor;
    @NotBlank(message = "Título obrigatório.")
    private String titulo;
    private String descricao;
    @NotNull(message = "Data de criação obrigatório")
    private LocalDateTime dataCriacao;
}

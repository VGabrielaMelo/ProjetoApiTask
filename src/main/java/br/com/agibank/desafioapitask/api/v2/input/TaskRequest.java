package br.com.agibank.desafioapitask.api.v2.input;

import br.com.agibank.desafioapitask.enuns.PrioridadeTask;
import br.com.agibank.desafioapitask.enuns.StatusTask;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {

    @NotBlank(message = "Título obrigatório.")
    private String titulo;
    private StatusTask status;
    private String descricao;
    private PrioridadeTask prioridade;
    @NotNull(message = "Data de criação obrigatório")
    private LocalDateTime dataCriacao;
}

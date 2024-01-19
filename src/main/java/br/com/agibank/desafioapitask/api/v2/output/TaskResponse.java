package br.com.agibank.desafioapitask.api.v2.output;

import br.com.agibank.desafioapitask.enuns.PrioridadeTask;
import br.com.agibank.desafioapitask.enuns.StatusTask;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private String id;
    private String titulo;
    private StatusTask status;
    private String descricao;
    private PrioridadeTask prioridade;
    @JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;
}

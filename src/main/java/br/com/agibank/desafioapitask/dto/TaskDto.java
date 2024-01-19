package br.com.agibank.desafioapitask.dto;

import br.com.agibank.desafioapitask.enuns.PrioridadeTask;
import br.com.agibank.desafioapitask.enuns.StatusTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private String id;
    private String titulo;
    private StatusTask status;
    private String descricao;
    private PrioridadeTask prioridade;
    private LocalDateTime dataCriacao;
}

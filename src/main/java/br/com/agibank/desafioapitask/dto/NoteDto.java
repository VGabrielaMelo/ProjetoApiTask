package br.com.agibank.desafioapitask.dto;

import br.com.agibank.desafioapitask.enuns.CorNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {

    private String id;
    private CorNote cor;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
}

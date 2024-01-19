package br.com.agibank.desafioapitask.api.v3.output;

import br.com.agibank.desafioapitask.enuns.CorNote;
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
public class NoteResponse {

    private String id;
    private CorNote cor;
    private String titulo;
    private String descricao;
    @JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;
}

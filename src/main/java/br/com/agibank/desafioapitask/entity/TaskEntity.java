package br.com.agibank.desafioapitask.entity;

import br.com.agibank.desafioapitask.enuns.StatusTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskEntity {

    @Id
    private String id;

    @Column
    private String titulo;

    @Column
    private StatusTask status;

    @Column
    private String descricao;

    @Column
    private String prioridade;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}

package br.com.agibank.desafioapitask.entity;

import br.com.agibank.desafioapitask.enuns.StatusTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class TaskEntity {

    @Id
    private String idTask;

    @Column
    private String usuarioId;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private StatusTask status;

    @Column
    private String prioridade;
}

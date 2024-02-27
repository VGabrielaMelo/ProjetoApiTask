package br.com.agibank.desafioapitask.entity;

import br.com.agibank.desafioapitask.enuns.CorNote;
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
@Table(name = "annotation")
public class NoteEntity {

     @Id
     private String idAnnotation;

     @Column
     private String usuarioId;

     @Column
     private CorNote cor;

     @Column
     private String titulo;

     @Column
     private String descricao;
}

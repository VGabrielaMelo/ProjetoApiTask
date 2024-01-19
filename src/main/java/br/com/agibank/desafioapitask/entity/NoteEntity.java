package br.com.agibank.desafioapitask.entity;

import br.com.agibank.desafioapitask.enuns.CorNote;
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
@Table(name = "note")
public class NoteEntity {

     @Id
     private String id;

     @Column
     private CorNote cor;

     @Column
     private String titulo;

     @Column
     private String descricao;

     @Column(name = "data_criacao")
     private LocalDateTime dataCriacao;
}

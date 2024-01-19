package br.com.agibank.desafioapitask.repository;

import br.com.agibank.desafioapitask.entity.NoteEntity;
import br.com.agibank.desafioapitask.enuns.CorNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, String> {

    List<NoteEntity> findAllByDataCriacao(LocalDateTime dataCriacao);

    List<NoteEntity> findAllByCor(CorNote cor);
}

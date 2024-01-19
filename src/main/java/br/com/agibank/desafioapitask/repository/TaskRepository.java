package br.com.agibank.desafioapitask.repository;

import br.com.agibank.desafioapitask.enuns.StatusTask;
import br.com.agibank.desafioapitask.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, String> {

    Optional<TaskEntity> findById(String id);

    List<TaskEntity> findAllByStatus(StatusTask status);

    List<TaskEntity> findAllByDataCriacaoBeforeAndStatus(LocalDateTime limite, StatusTask status);
}

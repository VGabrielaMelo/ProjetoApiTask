package br.com.agibank.desafioapitask.config;

import br.com.agibank.desafioapitask.enuns.StatusTask;
import br.com.agibank.desafioapitask.entity.TaskEntity;
import br.com.agibank.desafioapitask.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Component
@EnableScheduling
public class ScheduledConfig {
    private TaskRepository taskRepository;

    @Scheduled(fixedDelay = 30000)
    public void timeDelete(){
        LocalDateTime timeDelete = LocalDateTime.now().minusDays(10);

        List<TaskEntity> tasksConcluidas = taskRepository.findAllByDataCriacaoBeforeAndStatus(timeDelete, StatusTask.DONE);

        for(TaskEntity taskEntity : tasksConcluidas){
            taskRepository.deleteById(taskEntity.getId());
        }
    }
}

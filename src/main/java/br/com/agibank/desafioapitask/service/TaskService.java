package br.com.agibank.desafioapitask.service;

import br.com.agibank.desafioapitask.entity.TaskEntity;
import br.com.agibank.desafioapitask.enuns.StatusTask;
import br.com.agibank.desafioapitask.api.v2.input.TaskRequest;
import br.com.agibank.desafioapitask.mapper.TaskMapper;
import br.com.agibank.desafioapitask.api.v2.output.TaskResponse;
import br.com.agibank.desafioapitask.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public List<TaskResponse> getTasks(StatusTask status) {
        List<TaskEntity> tasks = taskRepository.findAllByStatus(status);
        return taskMapper.mapToResponseList(tasks);
    }

    public TaskResponse saveTask(TaskRequest request) {
        TaskEntity taskEntity = taskMapper.mapToEntity(request);
        return taskMapper.mapToResponse(taskRepository.save(taskEntity));
    }

    public TaskResponse updateTask(String id, TaskRequest request) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado!"));

        taskEntity.setTitulo(request.getTitulo());
        taskEntity.setDescricao(request.getDescricao());

        return taskMapper.mapToResponse(taskRepository.save(taskEntity));
    }

    public TaskResponse updateTaskStatus(String id, StatusTask status) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrada!"));

        taskEntity.setStatus(status);

        return taskMapper.mapToResponse(taskRepository.save(taskEntity));
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}


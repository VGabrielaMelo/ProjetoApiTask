package br.com.agibank.desafioapitask.mapper;

import br.com.agibank.desafioapitask.enuns.PrioridadeTask;
import br.com.agibank.desafioapitask.api.v2.input.TaskRequest;
import br.com.agibank.desafioapitask.api.v2.output.TaskResponse;
import br.com.agibank.desafioapitask.entity.TaskEntity;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskResponse mapToResponse(TaskEntity taskEntity) {
        TaskResponse response = new TaskResponse();
        response.setId(taskEntity.getId());
        response.setTitulo(taskEntity.getTitulo());
        response.setStatus(taskEntity.getStatus());
        response.setDescricao(taskEntity.getDescricao());
        response.setPrioridade(PrioridadeTask.valueOf(taskEntity.getPrioridade()));
        response.setDataCriacao(taskEntity.getDataCriacao());
        return response;
    }

    public TaskEntity mapToEntity(TaskRequest request) {
        TaskEntity entity = new TaskEntity();
        entity.setTitulo(request.getTitulo());
        entity.setStatus(request.getStatus());
        entity.setDescricao(request.getDescricao());
        entity.setPrioridade(request.getPrioridade().name());
        entity.setDataCriacao(request.getDataCriacao());
        return entity;
    }

    public List<TaskResponse> mapToResponseList(List<TaskEntity> taskEntities) {
        return taskEntities.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }
}


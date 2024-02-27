package br.com.agibank.desafioapitask.mapper;

import br.com.agibank.desafioapitask.api.v3.input.NoteRequest;
import br.com.agibank.desafioapitask.api.v3.output.NoteResponse;
import br.com.agibank.desafioapitask.entity.NoteEntity;
import java.util.List;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class NoteMapper {

    public NoteEntity requestToEntity(NoteRequest request) {
        NoteEntity entity = new NoteEntity();
        entity.setCor(request.getCor());
        entity.setTitulo(request.getTitulo());
        entity.setDescricao(request.getDescricao());
        return entity;
    }

    public NoteResponse entityToResponse(NoteEntity entity) {
        NoteResponse response = new NoteResponse();
        response.setId(entity.getIdAnnotation());
        response.setCor(entity.getCor());
        response.setTitulo(entity.getTitulo());
        response.setDescricao(entity.getDescricao());
        return response;
    }

    public List<NoteResponse> entityToResponseList(List<NoteEntity> entities) {
        return entities.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }
}

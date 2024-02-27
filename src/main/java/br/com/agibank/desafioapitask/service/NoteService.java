package br.com.agibank.desafioapitask.service;

import br.com.agibank.desafioapitask.entity.NoteEntity;
import br.com.agibank.desafioapitask.enuns.CorNote;
import br.com.agibank.desafioapitask.api.v3.input.NoteRequest;
import br.com.agibank.desafioapitask.mapper.NoteMapper;
import br.com.agibank.desafioapitask.api.v3.output.NoteResponse;
import br.com.agibank.desafioapitask.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    private NoteRepository noteRepository;
    private NoteMapper noteMapper;

    public List<NoteResponse> getNoteByCor(CorNote corAtual) {
        List<NoteEntity> notes = noteRepository.findAllByCor(corAtual);
        return noteMapper.entityToResponseList(notes);
    }

    public NoteResponse getNoteById(String id) {
        NoteEntity entity = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anotação não encontrada."));

        return noteMapper.entityToResponse(entity);
    }

    public NoteResponse saveNote(NoteRequest request) {
        NoteEntity entity = noteMapper.requestToEntity(request);
        return noteMapper.entityToResponse(noteRepository.save(entity));
    }

    public NoteResponse updateNote(String id, NoteRequest request) {
        NoteEntity noteEntity = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado!"));

        noteEntity.setTitulo(request.getTitulo());
        noteEntity.setDescricao(request.getDescricao());

        return noteMapper.entityToResponse(noteRepository.save(noteEntity));
    }

    public void deleteNote(String id) {
        noteRepository.deleteById(id);
    }
}


package br.com.agibank.desafioapitask.api.v3.controller;

import br.com.agibank.desafioapitask.enuns.CorNote;
import br.com.agibank.desafioapitask.api.v3.input.NoteRequest;
import br.com.agibank.desafioapitask.api.v3.output.NoteResponse;
import br.com.agibank.desafioapitask.service.NoteService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v3/notes")
public class NoteController {

    NoteService service;

    @ApiOperation(value = "Busca as anotações que tem a mesma cor.",
            httpMethod = "GET")
    @GetMapping("/{cor}")
    public List<NoteResponse> getNoteByCor(@PathVariable("cor") CorNote cor) {

        return service.getNoteByCor(cor);
    }

    @ApiOperation(value = "Busca a anotação pelo id",
            httpMethod = "GET")
    @GetMapping("/{id}")
    public NoteResponse getNote(@PathVariable("id") String id) {

        return service.getNoteById(id);
    }

    @ApiOperation(value = "Cria uma nova anotação.",
            notes = "O título e a data de criação são obrigatórios.",
            httpMethod = "POST")
    @PostMapping("/save")
    public NoteResponse saveNote(@RequestBody @Validated NoteRequest request) {

        return service.saveNote(request);
    }

    @ApiOperation(value = "Busca uma anotação pelo ID e permite edita-la.",
            notes = "Não é possivel editar a data de criação, ele ira setar com a data e hora da ultima mudança.",
            httpMethod = "PUT")
    @PutMapping("update/{id}")
    public NoteResponse updateNote(@PathVariable("id") String id, @RequestBody @Validated NoteRequest request) {

        return service.updateNote(id, request);
    }

    @ApiOperation(value = "Busca uma anotação pelo ID e deleta-a.",
            notes = "Nesse método a resposta padrão é NO CONTENT (204).",
            httpMethod = "DELETE")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("delete/{id}")
    public void deleteNote(@PathVariable("id") String id) {

        service.deleteNote(id);
    }
}

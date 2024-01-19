package br.com.agibank.desafioapitask.api.v2.controller;

import br.com.agibank.desafioapitask.api.v2.input.TaskRequest;
import br.com.agibank.desafioapitask.api.v2.output.TaskResponse;
import br.com.agibank.desafioapitask.enuns.StatusTask;
import br.com.agibank.desafioapitask.service.TaskService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("v2/tasks")
public class TaskController {

    private TaskService taskService;

    @ApiOperation(value = "Devolve uma lista de tarefas.",
                    notes = "O usuário informa o status das tarefas que deseja analisar.",
                    httpMethod = "GET")
    @GetMapping("{status}")
    public List<TaskResponse> getTasks(@PathVariable("status") StatusTask status) {
        return taskService.getTasks(status);
    }

    @ApiOperation(value = "Devolve uma lista de tarefas.",
            notes = "O usuário informa o status das tarefas que deseja analisar.",
            httpMethod = "GET")
    @GetMapping("{id}")
    public TaskResponse getTask(@PathVariable("id") String id) {
        return taskService.getTask(id);
    }

    @ApiOperation(value = "Cria novas tarefas.",
            notes = "O título e a data de criação são obrigatórios.",
            httpMethod = "POST")
    @PostMapping
    public TaskResponse saveTask(@RequestBody @Validated TaskRequest request) {
        return taskService.saveTask(request);
    }

    @ApiOperation(value = "Busca uma tarefa pelo ID e permite edita-la.",
                    notes = "Nesse método não é possivel editar a data de criação e o status.",
                    httpMethod = "PUT")
    @PutMapping("{id}")
    public TaskResponse updateTask(@PathVariable("id") String id,
                                   @RequestBody @Validated TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @ApiOperation(value = "Busca uma tarefa pelo ID e permite editar o status.",
            notes = "Nesse método apenas o campo stauts é modificado.",
            httpMethod = "PATCH")
    @PatchMapping("{id}/{status}")
    public TaskResponse updateTaskStatus(@PathVariable("id") String id,
                                         @PathVariable("status") StatusTask status) {
        return taskService.updateTaskStatus(id, status);
    }

    @ApiOperation(value = "Busca uma tarefa pelo ID e deleta-a.",
            notes = "Nesse método a resposta padrão é NO CONTENT (204).",
            httpMethod = "DELETE")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") String id) {
        taskService.deleteTask(id);
    }
}

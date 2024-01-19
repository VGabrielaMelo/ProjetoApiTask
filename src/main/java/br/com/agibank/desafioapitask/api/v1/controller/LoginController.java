package br.com.agibank.desafioapitask.api.v1.controller;

import br.com.agibank.desafioapitask.api.v1.input.UserRequest;
import br.com.agibank.desafioapitask.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("v1/autenticar")
    public ResponseEntity<String> autenticarUsuario(@RequestBody UserRequest userRequest) {
        boolean autenticado = loginService.login(userRequest);
        if (autenticado) {
            return ResponseEntity.ok("Usuário autenticado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação");
        }
    }

    @PostMapping("v1/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody UserRequest userRequest) {
        try {
            loginService.novoUsuario(userRequest);
            return ResponseEntity.ok("Usuário registrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}


package br.com.agibank.desafioapitask.service;

import br.com.agibank.desafioapitask.entity.UserEntity;
import br.com.agibank.desafioapitask.api.v1.input.UserRequest;
import br.com.agibank.desafioapitask.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    private LoginRepository userRepository;

    public Boolean login(UserRequest userRequest) {
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return userRequest.getPassword().equals(userEntity.getPassword());
    }

    public void novoUsuario(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("Email já registrado");
        }

        UserEntity novoUser = new UserEntity(userRequest.getEmail(), userRequest.getPassword());
        userRepository.save(novoUser);
    }
}

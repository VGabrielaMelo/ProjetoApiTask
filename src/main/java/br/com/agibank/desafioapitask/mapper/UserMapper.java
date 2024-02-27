package br.com.agibank.desafioapitask.mapper;

import br.com.agibank.desafioapitask.entity.UserEntity;
import br.com.agibank.desafioapitask.api.v1.input.UserRequest;
import br.com.agibank.desafioapitask.api.v1.output.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse mapToResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getIdLogin());
        response.setEmail(entity.getEmail());
        return response;
    }

    public UserEntity mapToEntity(UserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setEmail(request.getEmail());
        entity.setSenha(request.getSenha());
        return entity;
    }
}


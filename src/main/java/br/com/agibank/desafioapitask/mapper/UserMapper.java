package br.com.agibank.desafioapitask.mapper;

import br.com.agibank.desafioapitask.dto.UserDto;
import br.com.agibank.desafioapitask.entity.UserEntity;
import br.com.agibank.desafioapitask.api.v1.input.UserRequest;
import br.com.agibank.desafioapitask.api.v1.output.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto entityToDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public UserResponse mapToResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setEmail(entity.getEmail());
        return response;
    }

    public UserEntity mapToEntity(UserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setEmail(request.getEmail());
        entity.setPassword(request.getPassword());
        return entity;
    }
}


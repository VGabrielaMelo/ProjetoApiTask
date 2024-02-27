package br.com.agibank.desafioapitask.api.v1.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Obrigatorio")
    private String email;

    @NotBlank(message = "Obrigatorio")
    private String senha;
}

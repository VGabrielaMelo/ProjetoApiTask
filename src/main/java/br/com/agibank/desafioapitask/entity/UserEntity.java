package br.com.agibank.desafioapitask.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login")
public class UserEntity {

    @Id
    private String idLogin;

    @Column
    private String email;

    @Column
    private String senha;
}

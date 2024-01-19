package br.com.agibank.desafioapitask.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login")
public class UserEntity {

    @Id
    private String id;

    @Column
    private String email;

    @Column
    private String password;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

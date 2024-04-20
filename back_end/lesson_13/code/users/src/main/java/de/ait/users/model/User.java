package de.ait.users.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_user2")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Schema(name = "UserClass", description = "Пользователь системы")
public class User {
    @Schema(description = "id пользователя", example = "234")
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Schema(description = "имя пользователя", example = "andy")

    @Column(name = "name")
    private String name;
    @Schema(description = "пароль", example = "j!uew773")

    @Column(name="password")
    private String password;

    @Schema(description = "email пользователя", example = "andy@mail.com")
    @Column(name="email")
    private String email;

    @Column(name="age")
    @Schema(description = "возраст пользователя", example = "43")
    private int age;
}

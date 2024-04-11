package de.ait.users.dto;

import de.ait.users.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@ToString
@Builder
@Schema(name = "User", description = "Пользователь системы")
public class UserRequestDTO {
    @Schema(description = "id пользователя", example = "234")
    private Long id;
    @Schema(description = "имя пользователя", example = "andy")
    private String name;
    @Schema(description = "email пользователя", example = "andy@mail.com")
    private String email;
    @Schema(description = "возраст пользователя", example = "43")
    private int age;

    public static UserRequestDTO from(User user){
        return UserRequestDTO.builder()
                .id(user.getId())
                .age(user.getAge())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
    public static List<UserRequestDTO> from(List<User> users){
        return users.stream().map(UserRequestDTO::from).collect(Collectors.toList());
    }

}

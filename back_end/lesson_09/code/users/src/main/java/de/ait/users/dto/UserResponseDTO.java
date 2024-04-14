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
public class UserResponseDTO {
    @Schema(description = "id пользователя", example = "234")
    private Long id;
    @Schema(description = "имя пользователя", example = "andy")
    private String name;
    @Schema(description = "email пользователя", example = "andy@mail.com")
    private String email;
    @Schema(description = "возраст пользователя", example = "43")
    private int age;

    public static UserResponseDTO from(User user){
        return UserResponseDTO.builder()
                .id(user.getId())
                .age(user.getAge())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
    public static List<UserResponseDTO> from(List<User> users){
        return users.stream().map(UserResponseDTO::from).collect(Collectors.toList());
    }

}

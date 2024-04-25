package de.ait.project.user.dto;

import de.ait.project.user.model.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {
    @NotBlank
    @NotNull
    @Size(min = 3, max=30)
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$")
    private String lastName;

    @Email
    private String email;

    @Size(min=8,max=20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]+$", message = "should be strong" )
    private String password;

public static User toUser(UserRequestDto dto){
    return User.builder()
            .firstName(dto.getFirstName())
            .lastName(dto.getLastName())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
}

}

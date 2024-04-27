package de.ait.project.user.dto;

import de.ait.project.user.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="User Request", description = "Request for create new user")
public class UserRequestDto {

    @Schema(description = "First name", example = "Andy")
    @NotBlank
    @NotNull
    @Size(min = 3, max=30)
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Should contain only Latin letters, start with capital letters")
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

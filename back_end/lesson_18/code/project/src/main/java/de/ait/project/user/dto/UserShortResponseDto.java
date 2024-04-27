package de.ait.project.user.dto;

import de.ait.project.advertisement.dto.AdvertisementResponseDto;
import de.ait.project.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserShortResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


    public static UserShortResponseDto from(User user){
        return UserShortResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }
    public static List<UserShortResponseDto> from(List<User> users){
        return users.stream()
                .map(u-> UserShortResponseDto.from(u))
                .collect(Collectors.toList());
    }

}

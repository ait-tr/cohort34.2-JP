package de.ait.project.user.dto;

import de.ait.project.advertisement.dto.AdvertisementResponseDto;
import de.ait.project.advertisement.model.Advertisement;
import de.ait.project.user.model.User;
import de.ait.project.user.repository.UserRepository;
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
public class UserResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AdvertisementResponseDto> advertisementDtos;

    public static UserResponseDto from(User user){
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .advertisementDtos( AdvertisementResponseDto.of(user.getAdvertisements()) )
                .build();
    }
    public static List<UserResponseDto> from(List<User> users){
        return users.stream()
                .map(u-> UserResponseDto.from(u))
                .collect(Collectors.toList());
    }

}

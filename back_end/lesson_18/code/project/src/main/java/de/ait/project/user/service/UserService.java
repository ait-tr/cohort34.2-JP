package de.ait.project.user.service;

import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.user.dto.UserRequestDto;
import de.ait.project.user.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);

    UserResponseDto save(UserRequestDto userRequestDto);

    UserResponseDto addAdvertisement(Long userId, AdvertisementRequestDto advertisementRequestDto);


}

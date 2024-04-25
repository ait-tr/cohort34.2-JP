package de.ait.project.user.service;

import de.ait.project.advertisement.dto.AdvertisementRequestDto;
import de.ait.project.advertisement.model.Advertisement;
import de.ait.project.advertisement.repository.AdvertisementRepository;
import de.ait.project.exceptions.GeneralUnCheckedException;
import de.ait.project.exceptions.UserNotFoundException;
import de.ait.project.user.dto.UserRequestDto;
import de.ait.project.user.dto.UserResponseDto;
import de.ait.project.user.model.User;
import de.ait.project.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AdvertisementRepository advertisementRepository;
    private final Logger logger; // = LogManager.getLogger(UserServiceImpl.class);


    @Override
    public List<UserResponseDto> findAll() {
        return UserResponseDto.from(userRepository.findAll());
    }

    @Override
    public UserResponseDto findById(Long id) {
        logger.info(String.format("Info: arg %d  ", id));
        logger.error("Error {}",id);
        logger.debug("Debug");

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Author id" + id + " not found"));
        return UserResponseDto.from(user);
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User createdUser = userRepository.save(UserRequestDto.toUser(userRequestDto));
        return UserResponseDto.from(createdUser);
    }

    @Override
    public UserResponseDto addAdvertisement(Long userId, AdvertisementRequestDto advertisementRequestDto) {
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
        Advertisement advertisement = Advertisement.builder()
                .title(advertisementRequestDto.getTitle())
                .description(advertisementRequestDto.getDescription())
                .category(advertisementRequestDto.getCategory())
                .author(user)
                .build();
        advertisementRepository.save(advertisement);

        return UserResponseDto.from(user);
    }
}


// OFF
// FATAL
// ERROR
// WARN
// INFO  -----
// DEBUG
// TRACE

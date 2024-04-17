package de.ait.users.services.impl;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.dto.UserResponseDTO;
import de.ait.users.model.User;
import de.ait.users.repositories.UserJpaRepository;
import de.ait.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository repository;
    //private final UserRepository repository;
    private final ModelMapper  mapper;
    private final Scanner scanner;

    @Override
    public List<UserResponseDTO> findAll() {
        return UserResponseDTO.from(repository.findAll());
    }

    @Override
    public List<UserResponseDTO> findAll(int age) {
        if(age==0) {
            return findAll();
        } else {
            return  UserResponseDTO.from(repository.findAll()).stream().filter(u->u.getAge()==age).collect(Collectors.toList());
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }


    @Override
    public User add(UserRequestDTO user) {
        User newUser = new User(null, user.getName(), user.getPassword(), user.getEmail(), user.getAge());
        User added= repository.save(newUser);
        return added;
    }

    @Override
    public UserResponseDTO userUpdate(UserRequestDTO userDto, Long userID) {
        User user = new User(userID, userDto.getName(),userDto.getPassword(),userDto.getEmail(),userDto.getAge());
        User updatedUser = repository.save(user);
        return UserResponseDTO.from(updatedUser);
    }

    @Override
    public void deleteById(Long id) {
        //TODO check user exist
        repository.deleteById(id);
    }
}

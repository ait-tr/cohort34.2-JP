package de.ait.users.services.impl;

import de.ait.users.dto.UserRequestDTO;
import de.ait.users.model.User;
import de.ait.users.repositories.UserRepository;
import de.ait.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper  mapper;
    private final Scanner scanner;

    @Override
    public List<UserRequestDTO> findAll() {
        return UserRequestDTO.from(repository.findAll());
    }

    @Override
    public List<UserRequestDTO> findAll(int age) {
        if(age==0) {
            return findAll();
        } else {
            return  UserRequestDTO.from(repository.findAll()).stream().filter(u->u.getAge()==age).collect(Collectors.toList());
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public User add(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        //TODO check user exist
        repository.deleteById(id);
    }
}

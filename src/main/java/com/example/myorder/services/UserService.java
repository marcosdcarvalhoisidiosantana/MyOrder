package com.example.myorder.services;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.api.mappers.UserMapper;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.entities.User;
import com.example.myorder.exceptions.AlreadyExistsException;
import com.example.myorder.exceptions.NotFoundException;
import com.example.myorder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDto create(CreateUserDto createUserDto) {
            validateUserEmail(createUserDto.getEmail());
            User user = userRepository.save(createUser(createUserDto));

            return UserMapper.toResponseDto(user);
    }


    private User createUser(CreateUserDto createUserDto) {
        return new User()
                .setEmail(createUserDto.getEmail())
                .setName(createUserDto.getName())
                .setPhone(createUserDto.getPhone())
                .setPassword(createUserDto.getPassword())
                .setAddress(createUserDto.getAddress());
    }

    private void validateUserEmail(String email) {
        User user = userRepository.findByEmail(email);

        if(user != null) {
            throw new AlreadyExistsException("Já existe um usuário cadastrado com esse email");
        }
    }

    public UserResponseDto getByEmail(String email) {
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmail(email));
        if(!optional.isPresent()) {
            throw new NotFoundException("Nao existe um usuario com o email: " + email);
        }
        User user = optional.get();
        return new UserResponseDto()
                .setEmail(user.getEmail())
                .setAddress(user.getAddress())
                .setId(user.getId())
                .setPhone(user.getPhone())
                .setName(user.getName());
    }

    public List<UserResponseDto> listAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> userResponseList = new ArrayList<>();

        for(User user : users) {
            UserResponseDto userResponse = new UserResponseDto()
                    .setEmail(user.getEmail())
                    .setAddress(user.getAddress())
                    .setId(user.getId())
                    .setPhone(user.getPhone())
                    .setName(user.getName());
            userResponseList.add(userResponse);
        }
        return userResponseList;
    }




}

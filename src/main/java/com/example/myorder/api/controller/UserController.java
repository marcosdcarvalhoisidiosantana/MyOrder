package com.example.myorder.api.controller;

import com.example.myorder.api.RestPath;
import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(RestPath.BASE_PATH + "/users")
@Api(tags = "Usuários")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto create(
            @ApiParam(value = "Objeto que contem as informaçoes do usuario")
            @RequestBody
            @Valid
            CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public UserResponseDto get(@RequestParam @Param("email") String email) {
        return userService.getByEmail(email);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public List<UserResponseDto> getList() {
        return userService.listAll();
    }
}

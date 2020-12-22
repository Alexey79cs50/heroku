package com.generate.users.application.controller;

import com.generate.users.application.model.User;
import com.generate.users.application.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(tags = "User static data", value = "Return predefined sets of the data")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Get pre-defined list of 10 unique users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single pre-defined User (indexes from 1 to 10")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getUsersById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }
}

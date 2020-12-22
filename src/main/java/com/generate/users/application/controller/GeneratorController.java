package com.generate.users.application.controller;

import com.generate.users.application.model.User;
import com.generate.users.application.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generate")
@Api(tags = "User dynamic data", value = "Generate random sets of the data")
@AllArgsConstructor
public class GeneratorController {

    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "Generate random User")
    @ResponseStatus(HttpStatus.OK)
    public User generateUser() {
        return userService.generateUser();
    }

    @GetMapping("/{count}")
    @ApiOperation(value = "Generate set of unique users (100 maximum)")
    @ResponseStatus(HttpStatus.OK)
    public List<User> generateUserList(@PathVariable Integer count) {
        return userService.generateUserList(count);
    }
}
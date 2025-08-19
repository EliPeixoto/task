package com.elipeixoto.taks.controller;

import com.elipeixoto.taks.dto.UserDto;
import com.elipeixoto.taks.entities.User;
import com.elipeixoto.taks.mapper.UserMapper;
import com.elipeixoto.taks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> listaUsuarios() {
        return ResponseEntity.ok(service.listaUsuario());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UserDto> salvarUsuario(@RequestBody UserDto userDto) {
        service.salvarUsuario(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);

    }

}

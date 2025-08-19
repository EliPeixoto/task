package com.elipeixoto.taks.controller;

import com.elipeixoto.taks.entities.User;
import com.elipeixoto.taks.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> listaUsuarios(){
        List<User> usuarios = service.listaUsuario();

        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

}

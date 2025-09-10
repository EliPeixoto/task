package com.elipeixoto.taks.controller;

import com.elipeixoto.taks.dto.UserDto;
import com.elipeixoto.taks.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @GetMapping("/listar-todos")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<UserDto>> listaUsuarios() {
        return ResponseEntity.ok(service.listaUsuario());
    }

    @PostMapping("/salvar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDto> salvarUsuario(@Valid @RequestBody UserDto userDto) {
        UserDto salvo = service.salvarUsuario(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<UserDto>listaUsuarioPorId(@PathVariable  Long id){
        UserDto userDto = service.listaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletaUsuario(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletaUsuario(id));
    }
}

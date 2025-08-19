package com.elipeixoto.taks.services;

import com.elipeixoto.taks.entities.User;
import com.elipeixoto.taks.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public List<User> listaUsuario() {
        List<User> usuariosSalvos = repository.findAll();
        return usuariosSalvos;
    }

}

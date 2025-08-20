package com.elipeixoto.taks.services;

import com.elipeixoto.taks.dto.UserDto;
import com.elipeixoto.taks.entities.User;
import com.elipeixoto.taks.mapper.UserMapper;
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
    private final UserMapper mapper;

    public List<UserDto> listaUsuario() {
        List<User> usuariosSalvos = repository.findAll();
        return mapper.toDtoList(usuariosSalvos);
    }

    public UserDto salvarUsuario(UserDto userDto) {
        log.info("Salvando usuario: {}", userDto);
        User user = mapper.toEntity(userDto);
        user.setNome(userDto.nome());
        user.setEmail(userDto.email());
        user.setTelefone(userDto.telefone());
        user.setStatus(userDto.status());
        user.setCriadoPor("NOME TESTE");
        user.setAtualizadoPor("NOME TESTE");
        user.setCriadoEm(java.time.LocalDateTime.now());

        User usuarioSalvo = repository.save(user);
        return mapper.toDto(usuarioSalvo);
    }

    public UserDto listaPorId(Long id) {
        User user = repository.findById(id).orElseThrow();
        UserDto userDto = mapper.toDto(user);
        return userDto;
    }

    public Void deletaUsuario(Long id){
        repository.deleteById(id);
        return null;
    }
}

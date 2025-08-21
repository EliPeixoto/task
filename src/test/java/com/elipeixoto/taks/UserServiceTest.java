package com.elipeixoto.taks;

import com.elipeixoto.taks.dto.UserDto;
import com.elipeixoto.taks.entities.User;
import com.elipeixoto.taks.mapper.UserMapper;
import com.elipeixoto.taks.repositories.UserRepository;
import com.elipeixoto.taks.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository repository;

    @Mock
    UserMapper mapper;

    @InjectMocks
    UserService service;

    User user;
    UserDto userDto;
    List<User> listaUsuario;
    List<UserDto> listaDto;


    @BeforeEach
    void setup(){
        user = new User();
        user.setId(1L);
        user.setNome("Nome");
        user.setEmail("email@");
        user.setTelefone("telefone");
        user.setStatus("A");

        LocalDate date = LocalDate.of(2025, 8, 21);
        LocalTime time = LocalTime.of(10, 30);
        LocalDateTime combinedDateTime = LocalDateTime.of(date, time);
        userDto = new UserDto(
                1L,
                "Nome",
                "email@",
                "telefone",
                "A"
        );
        listaUsuario = new ArrayList<>();
        listaUsuario.add(user);

        listaDto = new ArrayList<>();
        listaDto.add(userDto);
    }

    @Test
    void deveRetornarListaComSucesso(){
        when(repository.findAll()).thenReturn(listaUsuario);
        when(mapper.toDtoList(listaUsuario)).thenReturn(listaDto);

        List<UserDto> resultado = service.listaUsuario();
        assertEquals(1, resultado.size());

    }

    @Test
    void deveSalvarUsuarioComSucesso(){
      when(repository.save(user)).thenReturn(user);
      when(mapper.toEntity(userDto)).thenReturn(user);
      when(mapper.toDto(user)).thenReturn(userDto);

      UserDto resultado = service.salvarUsuario(userDto);

      assertEquals(userDto, resultado);

    }

    @Test
    void deveListaUsuarioPorId(){
        when(repository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        when(mapper.toDto(user)).thenReturn(userDto);

        UserDto resultado = service.listaPorId(user.getId());

        assertEquals(userDto, resultado);

    }

}

package com.elipeixoto.taks.dto;

public record UserDto(
        Long id,
        String nome,
        String email,
        String telefone,
        String status
) {
}

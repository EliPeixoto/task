package com.elipeixoto.taks.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        @NotBlank
        String nome,
        @Email
        String email,
        @Pattern(regexp = "\\(\\d{2}\\)\\d{4,5}-\\d{4}", message = "Formato inválido de telefone. Use (XX)XXXXX-XXXX ou (XX)XXXX-XXXX")
        String telefone,
        String status
) {
}

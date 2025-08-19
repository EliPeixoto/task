package com.elipeixoto.taks.entities;


import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Auditoria {

    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
    private String criadoPor;
    private String atualizadoPor;

}

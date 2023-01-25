package com.grupo_4.Proyecto_Inte_Grupo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class Cliente {
    @Id
    @Column("cliente_id")
    private long clienteId;

    private String nombre;

    private String telefono;

    private String direccion;
    
    private String email;

}


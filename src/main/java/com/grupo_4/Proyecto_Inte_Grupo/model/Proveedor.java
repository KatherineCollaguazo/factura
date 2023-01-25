package com.grupo_4.Proyecto_Inte_Grupo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class Proveedor {
    @Id
    @Column("proveedor_id")
    private long proveedorId;
    private String cedula;
    private String nombre;
    private String telefono;  
}

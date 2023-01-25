package com.grupo_4.Proyecto_Inte_Grupo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class Producto {
    @Id
    @Column("producto_id") 
    private long productoId;
    
    private String nombre;

    private String descripcion;

    private String precio;
    
    @Column("cantidad_productos_necesarios")
    private int cantidadProductosNecesarios;
}

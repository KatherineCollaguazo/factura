package com.grupo_4.Proyecto_Inte_Grupo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class FacturaYDetalle {
    
    private long facturaId;
    private Date fecha;
    private String observaciones;
    private long clienteId;
    private String clienteNombre;
    private long productoId;
    private String productoNombre;
    private int cantidadProductosRecibidos;
}
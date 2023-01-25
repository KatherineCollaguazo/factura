package com.grupo_4.Proyecto_Inte_Grupo.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.Data;

@Data
public class Factura {
    
    @Id
    @Column("factura_id")
    private long facturaId;
    private Date fecha;
    private String observacion;
    private String estado;

    @MappedCollection(idColumn = "factura_id")
    private Set<DetalleFactura> detalleFactura = new HashSet<>();

}

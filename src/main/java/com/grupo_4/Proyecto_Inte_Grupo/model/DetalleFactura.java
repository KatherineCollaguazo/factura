package com.grupo_4.Proyecto_Inte_Grupo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
public class DetalleFactura {
    
    @Id
    @Column("detalle_factura_id")
    private long detalleFacturaId;
    @Column("factura_id")
    private long facturaId;
    @Column("cliente_id")
    private long clienteId;
    @Column("producto_id")
    private long productoId;
    @Column("cantidad_productos_recibidos")
    private int cantidadProductosRecibidos;
}
